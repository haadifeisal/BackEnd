/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Controller.ChatController;
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
import model.entity.Meddelandet;

/**
 *
 * @author Haadi
 */
@Path("chat")
public class MeddelandetFacadeREST {
    
    @POST
    @Path("/addmessage")
    public void addMessage(
            @FormParam("Subject") String subject,
            @FormParam("Content") String content,
            @FormParam("Sender") String sender,
            @FormParam("Receiver") String receiver) {
        
        ChatController.insertMessage(subject, content, sender, receiver);
    }
    
    @GET
    @Path("/getmessages/{from}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Meddelandet> getMessages(@PathParam("from") String from){
        return ChatController.getSenderMessages(from);
    }
    
    public static void main(String[] args){
        MeddelandetFacadeREST msg=new MeddelandetFacadeREST();
        List<Meddelandet> l=msg.getMessages("haadi94");
        for(int  i=0;i<l.size();i++){
            System.out.println(l.get(i).getContent());
        }
        
    }
    
}
