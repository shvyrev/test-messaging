package io.kaller.messenger.services;

import io.vertx.mutiny.cassandra.CassandraClient;
import io.vertx.mutiny.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CassandraService {
    private static final Logger log = LoggerFactory.getLogger( CassandraService.class );

    @Inject
    Vertx vertx;
    private CassandraClient client;

    @PostConstruct
    void init(){
//        log.info(" $ init : " + vertx);
//        System.setProperty("cassandra.config", "file:///Users/sergey/Documents/projects/appmobiles_2020/kaller/messenger-rebuid/src/main/resources/cassandra.yaml");
//        CassandraDaemon.getInstanceForTesting().activate();
    }

    public boolean isAvailable() {
        return true;
//        client = CassandraClient.createNonShared(vertx, new CassandraClientOptions().setPort(9042));
//        return client.isConnected();
    }
//
//
//    @PreDestroy
//    void onClose(){
//        log.info(" $ onClose : " + "");
//    }
}
