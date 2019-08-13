package com.nchu.hospital_system.bean;

public class Doctor {
    private String account;
    private String password;
    private String name;
    private String phone;
    private String position;
    private String dept;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String postion) {
        this.position = postion;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
