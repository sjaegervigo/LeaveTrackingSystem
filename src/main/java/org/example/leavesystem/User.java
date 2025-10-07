package org.example.leavesystem;

import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final Integer id;
    private String name;
    private String email;
    private String password;

    public User() {
        this.id = count.incrementAndGet();
        this.name = "Name needs to be set";
        this.email = "Email needs to be set";
        this.password = "Password needs to be set";
    }

    public User(String name, String email, String password) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
