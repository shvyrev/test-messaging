package io.kaller.messenger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

@ServerEndpoint("/chat/{phoneNumber}")
@ApplicationScoped
public class ApiSocket {

    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("phoneNumber") String phoneNumber) {
        sessions.put(phoneNumber, session);
        broadcastToAll("User " + phoneNumber + " joined");
    }

    @OnClose
    public void onClose(Session session, @PathParam("phoneNumber") String phoneNumber) {
        sessions.remove(phoneNumber);
        broadcastToAll("User " + phoneNumber + " left");
    }

    @OnError
    public void onError(Session session, @PathParam("phoneNumber") String phoneNumber, Throwable throwable) {
        sessions.remove(phoneNumber);
        broadcastToAll("User " + phoneNumber + " left on error: " + throwable);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("phoneNumber") String phoneNumber) {
        broadcastToAll(">> " + phoneNumber + ": " + message);
    }

    public void sendSupportMessage(String phoneNumber, String message){
        broadcastTo(phoneNumber, message);
    }

    private void broadcastTo(String phoneNumber, String message) {
        final Session session = sessions.get(phoneNumber);
        if (session != null) {
            session.getAsyncRemote().sendObject(message, result ->  {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        }
    }

    private void broadcastToAll(String message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message, result ->  {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        });
    }
}
