package demo.group;

import org.acme.g1.Library1Greeting;
import org.acme.g2.Library2Greeting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        Library1Greeting g1 = new Library1Greeting();
        Library2Greeting g2 = new Library2Greeting();
        
        return String.format("{ \"g1\" :\"%s\", \"g2\" : \"%s\"}", g1.sayHello(), g2.sayHello());
    }
}
