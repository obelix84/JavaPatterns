package ru.gb.socialnet.repository;

//CREATE TABLE `socialnetwork`.`friends` (
//        `user_id` BIGINT NOT NULL,
//        `friend_id` BIGINT NOT NULL,
//        PRIMARY KEY (`user_id`, `friend_id`),
//        INDEX `FK_user_friend_idx` (`friend_id` ASC) VISIBLE,
//        CONSTRAINT `FK_friend_user`
//        FOREIGN KEY (`user_id`)
//        REFERENCES `socialnetwork`.`userprofile` (`id`)
//        ON DELETE NO ACTION
//        ON UPDATE NO ACTION,
//        CONSTRAINT `FK_user_friend`
//        FOREIGN KEY (`friend_id`)
//        REFERENCES `socialnetwork`.`userprofile` (`id`)
//        ON DELETE NO ACTION
//        ON UPDATE NO ACTION);

import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.db.DatabaseInterface;
import ru.gb.socialnet.domain.UserProfile;
import ru.gb.socialnet.domain.UserProfileBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FriendsRepository implements CrudRepository<UserProfile, Long>, DatabaseInterface {

    private final DatabaseHandler dbh;
    private final Connection conn;
    private UserProfileBuilder userBuilder;

    PreparedStatement psGetAllFriendsById;

    public FriendsRepository(DatabaseHandler dbh) {
        this.dbh = dbh;
        this.conn = dbh.getConnection();
        this.userBuilder = new UserProfileBuilder();
        try {
            psGetAllFriendsById = conn.prepareStatement(
                    "SELECT u.id, u.fname, u.lname, u.nickname, u.sex, u.dob" +
                    " FROM socialnetwork.userprofile u, socialnetwork.friends f" +
                            " WHERE u.id = f.friend_id AND f.user_id = ?;");
        } catch (SQLException th) {
            th.printStackTrace();
        }
    }


    @Override
    public Optional<UserProfile> findById(Long aLong) {
        return Optional.empty();
    }

    public List<UserProfile> findAllById(Long aLong) {
        List<UserProfile> friends = new ArrayList<>();
        try {
            psGetAllFriendsById.setLong(1, aLong);
            ResultSet rs = psGetAllFriendsById.executeQuery();
            while (rs.next()) {
                userBuilder.setId(rs.getLong(1));
                userBuilder.setFName(rs.getString(2));
                userBuilder.setLName(rs.getString(3));
                userBuilder.setNickName(rs.getString(4));
                userBuilder.setDob(rs.getDate(6));
                userBuilder.setSex(rs.getString(5));
                friends.add(userBuilder.getResult());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friends;
    }

    @Override
    public <S extends UserProfile> S save(S entity) {
        return null;
    }

    @Override
    public void delete(UserProfile entity) {

    }

    @Override
    public void disconnect() {
        try {
            psGetAllFriendsById.close();
            dbh.disconnect();
        } catch (SQLException th) {
            th.printStackTrace();
        }
    }
}
