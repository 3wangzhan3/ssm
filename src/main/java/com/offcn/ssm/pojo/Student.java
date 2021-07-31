package com.offcn.ssm.pojo;


public class Student {
    private Integer id;
    private String username;
    private Integer age;
    private String password;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(Integer id, String username, Integer age, String password) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.password = password;
    }
}
