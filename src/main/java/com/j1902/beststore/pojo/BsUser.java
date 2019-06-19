package com.j1902.beststore.pojo;

import java.util.Date;

public class BsUser {
    private Integer id;

    private String nickname;

    private String email;

    private String password;

    private String phone;

    private String address;

    private Date lastLogin;

    private Date nowLogin;

    private String lastIp;

    private String nowIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getNowLogin() {
        return nowLogin;
    }

    public void setNowLogin(Date nowLogin) {
        this.nowLogin = nowLogin;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    public String getNowIp() {
        return nowIp;
    }

    public void setNowIp(String nowIp) {
        this.nowIp = nowIp == null ? null : nowIp.trim();
    }
}