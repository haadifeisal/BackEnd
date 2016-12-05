/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.entity.Meddelandet;

/**
 *
 * @author Haadi
 */
public class ChatDb {
    
     private String tag = "BackEndPU";
    
    public List<Meddelandet> getAllMessages(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager(); 
        try{
            Query query = em.createQuery("SELECT m FROM Meddelandet m");
            //query.setParameter(1,id);
            List<Meddelandet> mess = query.getResultList();
            return mess;
            
        }catch(Exception e){
            return null;
        }
    }
    
    public void insertMessage(Meddelandet chat){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(chat);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
    
    public Meddelandet getChatById(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        Meddelandet chat=(Meddelandet) em.find(Meddelandet.class, id);
        if(chat!=null){
           return chat; 
        }
        return null;
    }
    
    /*public static void main(String[] argsss){
        ChatDb db = new ChatDb();
        UserDb db2 = new UserDb();
        List<Meddelandet> list = db.getAllMessages();
        for(int i=0;i<list.size();i++){
            System.out.println("Messages: " + list.get(i).getContent());
        }
        //System.out.println("Message: " + db.getUserById(1).getContent());
        //db.insertMessage(new Meddelandet("ronaldo vs messi","who is the greatest fotballer ever",db2.getUserById(2),db2.getUserById(3)));
    }*/
    
}
