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
import model.entity.User;

/**
 *
 * @author Haadi
 */
public class UserDb {
    
    private String tag = "BackEndPU";
     
     public List<User> getAllUsers(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createQuery("SELECT u FROM User u");
            List<User> users = query.getResultList();
            return users;
        }catch(Exception e){
            return null;
        }
    }
    
    public void register(User user){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            if(user.getPassword().equals(user.getConfirmpassword())){
                em.persist(user);
                em.getTransaction().commit();
            }
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }finally{
            em.close();
            emf.close();
        }
    }
 
    public boolean checkLogin(String username, String password){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username=?1 and u.password=?2");
            query.setParameter(1, username);
            query.setParameter(2, password);
            if(query.getSingleResult()!=null){
                return true;
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }
    
    public List<User> getUsersByUsername(String username){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username LIKE :username");
            query.setParameter("username", "%"+username+"%");
             List<User> users = query.getResultList();
             return users;
        }catch(Exception e){
            if(em==null){
                return null;
            }
        }
        return null;
    }
    
    public User getUserByName(String username){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username=?1");
            query.setParameter(1, username);
             User user = (User) query.getSingleResult();
             return user;
        }catch(Exception e){
            if(em==null){
                return null;
            }
        }
        return null;
    }
    
    public boolean checkIfUserExists(String username){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username=?1");
            query.setParameter(1, username);
            User user = (User) query.getSingleResult();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public User getUserById(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tag);
        EntityManager em = emf.createEntityManager();
        User user=(User) em.find(User.class, id);
        if(user!=null){
           return user; 
        }
        return null;
    }
    
    /*public static void main(String [] args){
        UserDb usr = new UserDb();
        //System.out.println("User exists: " + usr.checkLogin("suarez", "soso"));
        //usr.register(new User("goku","ss4"));
        List<User> list = usr.getUsersByUsername("a");
       for(int i=0;i<list.size();i++){
           System.out.println("Users: " + list.get(i).getUsername());
        }
        //System.out.println("User: " + usr.getUserByName("haadi94").getName());
        //System.out.println("Exists: " + usr.checkIfUserExists("haadi94"));
        //System.out.println("User: " + usr.getUserByUsername("haadi").getPassword());
        //usr.register(new User("haadi feisal","haadi@hotmail.com","haadi94","hej","hej"));
      //  System.out.println("User exists: " + usr.UserExists("yasin"));
        //usr.register(new User("haadi feisal","haadi@hotmail.com","haadi94","hej","hej"));
        //System.out.println("User Exists: " + usr.UserExists("haadi94"));
    }*/
    
}
