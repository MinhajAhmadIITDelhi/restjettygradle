package sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {

    @GET
    @Path("{name}")
    public String hello(@PathParam("name") String name) {
        return "Hello " + name + "!!";
    }

    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public User json() {
    	User user = new User("json-user", 34);
        return user;
    }

    @GET
    @Path("xml")
    @Produces(MediaType.APPLICATION_XML)
    public User xml() {
    	User user = new User("xml-user", 45);
        return user;
    }
}

