package demo2.group;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/frontend")
public class Frontend {

    @GET
    @Produces(MediaType.APPLICATION_JSON )
    public String message() {
       
        return "{ \"status\" : 200, \"message\" : \"Hello from your frontend\"}";
    }
}
