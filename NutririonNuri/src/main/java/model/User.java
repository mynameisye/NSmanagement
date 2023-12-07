package model;

import java.time.LocalDate;
import java.util.Date;

public class User { //User
    private int memid;
    private String id;
    private String pw;
    private String name;
    private char gender; //피드백(DB설계): gender, smoke등은 char(1)로 사용
    private String phone;
    private LocalDate birthDay;
    private String email;
    
    //생성자
    public User() {};
    public User(int memid, String id, String pw, String name, char gender, String phone, LocalDate birthDay, String email) {
        this.memid = memid;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.birthDay = birthDay;
        this.email = email;
    };
    
    public User(int memId, String id, String password, String name, String email, String phone) {
        this.id = id;
        this.memid = memId;
        this.pw = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    //getter, setter
    public int getMemid() {
        return memid;
    }
    public void setMemid(int memid) {
        this.memid = memid;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
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
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
