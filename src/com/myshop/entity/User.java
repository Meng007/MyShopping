package com.myshop.entity;

public class User {
    private Integer u_id;
    private String u_username;
    private String u_password;
    private String u_telephone;
    private String u_address;
    private Integer is_delete;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_username() {
        return u_username;
    }

    public void setU_username(String u_username) {
        this.u_username = u_username;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_telephone() {
        return u_telephone;
    }

    public void setU_telephone(String u_telephone) {
        this.u_telephone = u_telephone;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public User() {
    }

    public User(Integer u_id, String u_username, String u_password, String u_telephone, String u_address) {
        this.u_id = u_id;
        this.u_username = u_username;
        this.u_password = u_password;
        this.u_telephone = u_telephone;
        this.u_address = u_address;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_username='" + u_username + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_telephone='" + u_telephone + '\'' +
                ", u_address='" + u_address + '\'' +
                ", is_delete=" + is_delete +
                '}';
    }
}
