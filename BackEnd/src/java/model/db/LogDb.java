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
import model.entity.Log;

/**
 *
 * @author Haadi
 */
public class LogDb {
    
    private String tag = "BackEndPU";
    
     public void insertLog(Log from){  
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("ServerLabb1PU");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager manager = emf.createEntityManager();
        try{ 
           manager.getTransaction().begin();
           manager.persist(from);
           manager.getTransaction().commit();
        } catch (Exception e) {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            
            manager.close();
        }
    }
    
    public List<Log> getAllLogs(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createQuery("SELECT l FROM Log l");
            List<Log> logs = query.getResultList();
            return logs;
        }catch(Exception e){
            return null;
        }
    }
    
    public Log getLogById(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        Log log =(Log) em.find(Log.class, id);
        if(log!=null){
            return log;
        }
        return null;
    }
    
    /*public static void main(String[] args){
        LogDb db=new LogDb();
        UserDb dbb= new UserDb();
        List<Log> list = db.getAllLogs();
        for(int i=0;i<list.size();i++){
            System.out.println("Logs: " + list.get(i).getContent());
        }
            
       //Log log = new Log("Whats uppp woooorld!!",dbb.getUserById(1));
       //db.insertLog(log);
       //System.out.println("Log: " + db.getLogById(2).getContent());
    }*/
    
}
