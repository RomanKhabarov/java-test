package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_PLAIN)
    public String getIt() {
        return String.format("Got it! Text plain. %n");
    }

    @GET
    public Response getEntry() {
        return Response.ok().entity("Entity").build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postIt(@FormParam("key1") String key1,
                         @DefaultValue("defaultKey")  @FormParam("key2") String key2) {
        return String.format("Post it! key1: %s, key2: %s %n", key1, key2);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<body style='backgroundColor:blue'>Test Text</body>";
    }
}
