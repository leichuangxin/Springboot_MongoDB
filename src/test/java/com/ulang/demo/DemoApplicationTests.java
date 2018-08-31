package com.ulang.demo;

import com.ulang.Server.UserServer;
import com.ulang.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private UserServer userServer;

    @Test
    public void contextLoads() {
    }

    @Test
    public void insert() {
        User users = new User("5", "小5", 4, "123456");
        users.setAddress("青岛市");
        userServer.saveUser(users);
        List<User> list = userServer.listUser();
        System.out.println("一共这么多人:" + list.size());
    }

    @Test
    public void find() {
        User user = null;
        user = userServer.findUserByName("小2");
        //List<User> list = userServer.listUser();
        System.out.println(user.toString());
    }

    @Test
    public void delete() {
        User user = null;
        user = userServer.findUserByName("小2");
        System.out.println("第一次" + user.toString());
        userServer.removeUser("小2");
        //List<User> list = userServer.listUser();
        try {
            user = userServer.findUserByName("小2");

            System.out.println("第二次" + user.toString());
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Test
    public void update() {
        //  User user = new User("2", "小2", 12, "654321");
        userServer.updateUser("小2", "address", "654321");
        System.out.println("******" + userServer.findUserByName("小2").toString());

    }

    @Test
    public void queryList() {
        userServer.listUser().forEach(System.out::println);
    }


}
