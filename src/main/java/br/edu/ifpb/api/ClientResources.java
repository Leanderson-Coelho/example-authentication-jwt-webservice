package br.edu.ifpb.api;

import br.edu.ifpb.JWT.TokenManager;
import br.edu.ifpb.application.ClientServiceJPA;
import br.edu.ifpb.domain.model.Client;
import br.edu.ifpb.domain.model.SessionClient;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * @author Leanderson Coelho
 * @email leanderson.coelhoif@gmail.com
 */
@Stateless
@Path("clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResources {

    @Inject
    private ClientServiceJPA clientService;

    @POST
    public Response newUser(JsonObject json){
        clientService.save(new Client(
                json.getString("name"),
                json.getString("email"),
                json.getString("password")
        ));
        Logger.getLogger("").info("Salvando");
        return Response.created(null).build();
    }

    @GET
    @Path("{email}")
    public Response getUser(@PathParam("email")String email){
        Client client = this.clientService.find(email);
        if(client != null){
            return Response.ok()
                    .entity(client)
                    .build();
        }else{
            return Response
                    .noContent()
                    .build();
        }
    }

    @POST
    @Path("/login")
    public Response login(JsonObject jsonObject){
        Boolean login = this.clientService.login(new Client("", jsonObject.getString("email"), jsonObject.getString("password")));
        if(login){
            Client c = this.clientService.find(jsonObject.getString("email"));
            String token = TokenManager.create(c.getEmail());
            return Response.ok()
                    .entity(new SessionClient(c.getName(),c.getEmail(),token))
                    .build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
