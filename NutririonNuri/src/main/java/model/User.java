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
    private String email;
    
    //생성자
    public User() {};

    public User(String id, String pw, String name, char gender, String phone, String email) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }



    public User(int memid, String id, String pw, String name, char gender, String phone,
            String email) {
        super();
        this.memid = memid;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
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
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    /* 비밀번호 검사 */
    public boolean matchPassword(String password) {
        if (password == null) {
            return false;
        }
        return this.pw.equals(password);
    }
    
    public boolean isSameUser(String userid) {
        return id.equals(userid);
    }
}
