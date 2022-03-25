package ru.gb.socialnet.domain;

import java.util.Date;
import java.util.List;

public class UserProfileBuilder implements UserBuilder {
    private long id;
    private String fName;
    private String lName;
    private String nickName;
    private Date dob;
    private String sex;
    private List<UserProfile> friends;

    public UserProfile getResult() {
        return new UserProfile(id, fName, lName, nickName, dob, sex);
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void setFName(String fName) {
        this.fName = fName;
    }

    @Override
    public void setLName(String lName) {
        this.lName = lName;
    }

    @Override
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void setFriends(List<UserProfile> friends) {
        this.friends = friends;
    }
}
