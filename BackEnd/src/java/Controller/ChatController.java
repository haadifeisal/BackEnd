/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import model.db.ChatDb;
import model.db.UserDb;
import model.entity.Meddelandet;
import model.entity.User;

/**
 *
 * @author Haadi
 */
public class ChatController {
    
    public static List<Meddelandet> getSenderMessages(String username){ // metod för att hämta meddelandet som
        ChatDb db = new ChatDb();             // skickas till en specefik användare
        UserDb db2= new UserDb();
        List<Meddelandet> messages = db.getAllMessages();
        User usr = db2.getUserByName(username);
        List<Meddelandet> tmp = new ArrayList();
        for(int i=0;i<messages.size();i++){
            if(messages.get(i).getReciever().equals(usr)){
                tmp.add(messages.get(i));
            }
        }
        return tmp;
    }
    
    public static void insertMessage(String subject, String content, String sender, String reciever){
        ChatDb db = new ChatDb();
        UserDb db2 = new UserDb();
        db.insertMessage(new Meddelandet(subject,content,db2.getUserByName(sender),db2.getUserByName(reciever)));
    }
    
    public static boolean checkIfUserExist(String username){
        UserDb db = new UserDb();
        return db.checkIfUserExists(username);
    }
    /*public static void main(String [] args){
        ChatController mc = new ChatController();
        List<Meddelandet> list = mc.getSenderMessages("suarez");
        for(int i=0;i<list.size();i++){
            System.out.println("Content: " + list.get(i).getContent());
        }
    }*/
    
}
