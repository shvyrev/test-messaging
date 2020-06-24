package io.kaller.messenger.dto;

import java.time.ZonedDateTime;

public class Message {
    private Integer channelId;
    private boolean owner;
    private String text;
    private String shippingId;
    private String phoneNumberSender;
    private ZonedDateTime createdAt;

    public static Message of(Integer channelId, boolean owner, String text, String shippingId, String phoneNumberSender, ZonedDateTime createdAt) {
        final Message message = new Message();
        message.channelId = channelId;
        message.owner = owner;
        message.text = text;
        message.shippingId = shippingId;
        message.phoneNumberSender = phoneNumberSender;
        message.createdAt = createdAt;
        return message;
    }
}
