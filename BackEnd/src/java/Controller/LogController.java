/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import model.db.LogDb;
import model.entity.Log;
import model.entity.User;

/**
 *
 * @author Haadi
 */
public class LogController {
    
    public static void insertLog(String from, String content){
        LogDb logDb = new LogDb();
        /*serDb usrDb = new UserDb();
        User user = usrDb.getUserByName(from);
        Log log = new Log();
        log.setContent(content);
        log.setFromuser(user);
        logDb.insertLog(log);*/
        logDb.insertLog(new Log(content, UserController.getUserByName(from)));
    }
    
    public static List<Log> getLogs(String username){
        LogDb logDb = new LogDb();
        List<Log> tmp = new ArrayList();
        
        User user = UserController.getUserByName(username);
        List<Log> logs = logDb.getAllLogs();
        
        for(int i=0;i<logs.size();i++){
            if(logs.get(i).getFromuser().equals(user)){
                tmp.add(logs.get(i));
            }
        }
        return tmp;
    }
    
    /*public static List<Log> getAllLogs(String fromUser){
        LogDb db = new LogDb();
        return db.getAllLogs(fromUser);
    }*/
    
    /*public static void main(String [] args){
        LogController lg = new LogController();
        List<Log> list = lg.getLogs("haadi94");
        for(int i=0;i<list.size();i++){
            System.out.println("Content: " + list.get(i).getContent());
        }
    }*/
    
}
