/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Controller.LogController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.entity.Log;

/**
 *
 * @author Haadi
 */
@Path("log")
public class LogFacadeREST {

    
    
    @POST
    @Path("/addpost")
    public void addPost(@FormParam("From") String from, @FormParam("Content") String content) {
       LogController.insertLog(from, content);
    }
    
     @GET
    @Path("/getlogs/{from}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Log> getPosts(@PathParam("from") String from) {
        return LogController.getLogs(from);
    }
    
}