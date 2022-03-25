package ru.gb.socialnet.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

//CREATE TABLE `socialnetwork`.`channels` (
//        `id` BIGINT NOT NULL,
//        `name` VARCHAR(255) NOT NULL,
//        `creation_date` DATE NOT NULL,
//        PRIMARY KEY (`id`),
//        UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

//CREATE TABLE `socialnetwork`.`subscribers_type` (
//        `id` BIGINT NOT NULL AUTO_INCREMENT,
//        `type` VARCHAR(255) NOT NULL,
//        PRIMARY KEY (`id`),
//        UNIQUE INDEX `type_UNIQUE` (`type` ASC) VISIBLE);

//INSERT INTO `socialnetwork`.`subscribers_type` (`id`, `type`) VALUES ('1', 'admin');
//INSERT INTO `socialnetwork`.`subscribers_type` (`id`, `type`) VALUES ('2', 'subscriber');

//CREATE TABLE `socialnetwork`.`channel_subscribers` (
//        `chanel_id` BIGINT NOT NULL,
//        `userprofile_id` BIGINT NOT NULL,
//        `type_id` BIGINT NULL,
//        PRIMARY KEY (`chanel_id`, `userprofile_id`),
//        INDEX `FK_userprofile_id_idx` (`userprofile_id` ASC) VISIBLE,
//        INDEX `FK_type_id_idx` (`type_id` ASC) VISIBLE,
//        CONSTRAINT `FK_channel_id`
//        FOREIGN KEY (`chanel_id`)
//        REFERENCES `socialnetwork`.`channels` (`id`)
//        ON DELETE NO ACTION
//        ON UPDATE NO ACTION,
//        CONSTRAINT `FK_userprofile_id`
//        FOREIGN KEY (`userprofile_id`)
//        REFERENCES `socialnetwork`.`userprofile` (`id`)
//        ON DELETE NO ACTION
//        ON UPDATE NO ACTION,
//        CONSTRAINT `FK_type_id`
//        FOREIGN KEY (`type_id`)
//        REFERENCES `socialnetwork`.`subscribers_type` (`id`)
//        ON DELETE NO ACTION
//        ON UPDATE NO ACTION);


@ToString
@Getter
@Setter
public class Channel {
    private long id;
    private String name;
    private Date creationDate;
    private List<UserProfile> admins;
    private List<UserProfile> subscribers;

    public Channel() { }

    public Channel(long id, String name, Date creationDate, List<UserProfile> admins, List<UserProfile> subscribers) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.admins = admins;
        this.subscribers = subscribers;
    }
}
