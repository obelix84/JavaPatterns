package ru.gb.socialnet.domain;

import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
public class Channel {
    private long id;
    private String name;
    private Date creationDate;
    private List<UserProfile> admins;
    private List<UserProfile> subscribers;

    public Channel(String name) {
        this.name = name;
    }

    public Channel(long id, String name, Date creationDate, List<UserProfile> admins, List<UserProfile> subscribers) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.admins = admins;
        this.subscribers = subscribers;
    }
}
