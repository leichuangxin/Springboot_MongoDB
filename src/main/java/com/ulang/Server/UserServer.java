package com.ulang.Server;

import com.ulang.model.User;

import java.util.List;

public interface UserServer {
    void saveUser(User users);

    User findUserByName(String name);

    void removeUser(String name);

    void updateUser(String name, String key, String value);

    List<User> listUser();
}
