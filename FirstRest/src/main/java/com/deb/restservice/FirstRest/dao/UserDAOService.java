package com.deb.restservice.FirstRest.dao;

import com.deb.restservice.FirstRest.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    private int currentUserid=1005;
    static{
        users.add(new User(1001,"Debasis","Padhi", new Date()));
        users.add(new User(1002,"Gopala","Dasam", new Date()));
        users.add(new User(1003,"Pradeep","Chandra", new Date()));
        users.add(new User(1004,"Usmin","Sehu", new Date()));
        users.add(new User(1005,"Shimlee","Sengupta", new Date()));
    }
    public List<User> findAll(){
        return users;
    }
    public User save(User user){
        if(null==user.getUserId()){
            user.setUserId(++currentUserid);
        }
        users.add(user);
        return user;
    }
    public User getUser(int userId){
        for (User user : users){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }
}
