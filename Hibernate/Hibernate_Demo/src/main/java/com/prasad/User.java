package com.prasad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity(name = user_data) this is to change the jpa entity name only not the table name inside database

//To change the table name inside database or to access the mentioned table name
//@Table(name = user_data)

@Entity
public class User {

    @Id
    private int uid;

    //@Column(name = user_name) this will change the column name in database
    private String uname;
    private String tech;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }


}
