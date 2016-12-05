/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import model.db.UserDb;
import model.entity.User;

/**
 *
 * @author Haadi
 */
public class UserController {
    
    public static boolean checkLogin(String username, String password){
        UserDb db = new UserDb();
        return db.checkLogin(username, password);
    }
    
    public static User getUserByName(String username){
        UserDb db = new UserDb();
        return db.getUserByName(username);
    }
    
    public static List<User> getUsersByUsername(String username){
        UserDb db = new UserDb();
        return db.getUsersByUsername(username);
    }
    
    public static boolean UserExists(String username){
        UserDb db = new UserDb();
        List<User> users = db.getAllUsers();
        //User user = new User();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    
    public static void register(User user){
        UserDb db = new UserDb();
        db.register(user);
    }
    
    public static boolean checkIfUserExist(String username){
        UserDb db = new UserDb();
        return db.checkIfUserExists(username);
    }
    
}
