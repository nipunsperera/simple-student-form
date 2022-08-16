package util;

import com.jfoenix.controls.JFXTextField;

import java.io.Serializable;

public class Student implements Serializable { // can convert to byte now
    private String name;
    private String id;
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }



    public Student(String name, String id, String contact) {
        this.name = name;
        this.id = id;
        this.contact = contact;
    }






}
