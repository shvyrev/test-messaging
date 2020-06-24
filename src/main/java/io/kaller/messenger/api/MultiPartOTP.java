package io.kaller.messenger.api;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

public class MultiPartOTP {
    @FormParam("phone")
    @PartType(MediaType.TEXT_PLAIN)
    public String phoneNumber;

    @FormParam("password")
    @PartType(MediaType.TEXT_PLAIN)
    public String password;

    @Override
    public String toString() {
        return "MultiPartOTP{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
