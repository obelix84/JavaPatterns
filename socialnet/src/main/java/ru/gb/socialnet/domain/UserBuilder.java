package ru.gb.socialnet.domain;



import java.util.Date;

public interface UserBuilder {
    void setId(int id);
    void setFName(String fName);
    void setlName(String lName);
    void setNickName(String nickName);
    void setDob(Date dob);
    void setSex(String sex);
}
