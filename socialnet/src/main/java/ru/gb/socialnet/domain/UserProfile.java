package ru.gb.socialnet.domain;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class UserProfile {

//  CREATE TABLE `socialnetwork`.`userprofile` (
//  `id` BIGINT NOT NULL AUTO_INCREMENT,
//  `fname` VARCHAR(100) NULL,
//  `lname` VARCHAR(100) NULL,
//  `nickname` VARCHAR(100) NULL,
//  `dob` DATE NULL,
//  `sex` VARCHAR(6) NULL,
//   PRIMARY KEY (`id`));


    private long id;
    private String fName;
    private String lName;
    private String nickName;
    private Date dob;
    private String sex;
    private List<UserProfile> friends;

    public UserProfile(long id, String fName, String lName, String nickName, Date dob, String sex) {
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

    public void setFriends(List<UserProfile> friends) {
        this.friends = friends;
    }
}
