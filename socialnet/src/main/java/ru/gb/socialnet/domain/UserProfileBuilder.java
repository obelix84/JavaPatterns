package ru.gb.socialnet.domain;

import java.util.Date;

public class UserProfileBuilder implements UserBuilder {
    private int id;
    private String fName;
    private String lName;
    private String nickName;
    private Date dob;
    private String sex;

    public UserProfile getResult() {
        return new UserProfile(id, fName, lName, nickName, dob, sex);
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setFName(String fName) {
        this.fName = fName;
    }

    @Override
    public void setlName(String lName) {
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
}
