package com.ulang.model;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "users")
@CompoundIndexes({
        @CompoundIndex(name = "age_idx", def = "{'name': 1, 'age': -1}")
})
@Data
public class User implements Serializable,Comparable<User> {
    @Indexed
    private String uid;
    private String name;
    private int age;
    @Transient
    private String address;

    public User() {
    }

    public User(String uid, String name, int age) {
        this.uid = uid;
        this.name = name;
        this.age = age;
    }

    public User(String uid, String name, int age, String address) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.address = address;
    }


    @Override
    public int compareTo(User o1) {
        int result = 0;
        if(0==result){
            result = this.age-o1.getAge();
            if(0==result){
                result = - this.uid.compareTo(o1.getUid());
            }
        }
        return result;
    }

}
