package io.kaller.messenger;

import io.kaller.messenger.api.MultiPartOTP;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/service")
public class ServiceResource {

    private static final Logger log = LoggerFactory.getLogger( ServiceResource.class );

    @POST
    @Path("/message/support/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String supportMessage(@MultipartForm MultiPartOTP multiPartOTP) {
        log.info(" $ supportMessage : " + multiPartOTP);
        return "ok";
    }

    
}
