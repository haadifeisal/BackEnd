/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Controller.UserController;
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
import model.entity.User;

/**
 *
 * @author Haadi
 */
@Path("user")
public class UserFacadeREST  {

   
    @GET
    @Path("/name/{name}") //klienten anger {name}, vilket bildar ett url som går till denna Path /name/
    @Produces({MediaType.APPLICATION_JSON})   
    public User findByName(@PathParam("name") String name) {
        return Controller.UserController.getUserByName(name);
    }

    @POST
    @Path("/register")
    public void registerUser(  //i POST metoden anger vi FormParam och namn för att hämta data 
            @FormParam("name") String name,
            @FormParam("email") String email,
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("confirmpassword") String confirm)
            {
        
        UserController.register(new User(name, email, username, password,confirm));
    }
    
    @GET
    @Path("/login/{Username}/{Password}")
    @Produces({MediaType.APPLICATION_JSON})     
    public String loginUser(@PathParam("Username") String username,
            @PathParam("Password") String password){
         if(UserController.checkLogin(username, password))
            return "true";
        else
           return "false";
    }
    
    @GET
    @Path("/search/{search}")
    @Produces({MediaType.APPLICATION_JSON})   
    public List<User> searchByName(@PathParam("search") String search) {
        return UserController.getUsersByUsername(search);
    }
   

}