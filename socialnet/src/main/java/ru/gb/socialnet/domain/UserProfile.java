package ru.gb.socialnet.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserProfile {

    private int id;
    private String fName;
    private String lName;
    private String nickName;
    private Date dob;
    private String sex;

    public UserProfile(int id, String fName, String lName, String nickName, Date dob, String sex) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.nickName = nickName;
        this.dob = dob;
        this.sex = sex;
    }

    public void setSex(String sex) {
        if (sex.equals("male") || sex.equals("female"))
            this.sex = sex;
        else
            throw new IllegalArgumentException("Sex of User cannot be " + sex + "!");
    }
}
