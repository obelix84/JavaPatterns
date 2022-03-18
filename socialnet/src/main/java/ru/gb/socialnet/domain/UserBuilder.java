package ru.gb.socialnet.domain;



import java.util.Date;
import java.util.List;

public interface UserBuilder {
    void setId(long id);
    void setFName(String fName);
    void setLName(String lName);
    void setNickName(String nickName);
    void setDob(Date dob);
    void setSex(String sex);
    void setFriends(List<UserProfile> friends);
}
