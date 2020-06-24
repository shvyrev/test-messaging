package io.kaller.messenger.dto;

import java.util.Set;

public class Channel {
    private String name;
    private String iconUrl;
    private ChannelType type;
    private int newMessagesCount;
    private String creatorPhoneNumber;
    private String recipientPhoneNumber;
    private Set<String> members;
}
