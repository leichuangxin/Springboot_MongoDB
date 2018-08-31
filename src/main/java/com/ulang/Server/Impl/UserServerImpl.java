package com.ulang.Server.Impl;

import com.ulang.Server.UserServer;
import com.ulang.model.User;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserServerImpl implements UserServer {

    @Resource
    MongoOperations mongoTemplate;

    public void saveUser(User users) {
        mongoTemplate.save(users);
    }

    public User findUserByName(String name) {
        return mongoTemplate.findOne(
                new Query(Criteria.where("name").is(name)), User.class);
    }

    public void removeUser(String name) {
        mongoTemplate.remove(new Query(Criteria.where("name").is(name)),
                User.class);
    }

    public void updateUser(String name, String key, String value) {
        mongoTemplate.updateFirst(new Query(Criteria.where("name").is(name)),
                Update.update(key, value), User.class);

    }

    public List<User> listUser() {
        return mongoTemplate.findAll(User.class);
    }
}
