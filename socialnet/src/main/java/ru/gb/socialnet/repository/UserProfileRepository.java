package ru.gb.socialnet.repository;

import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.db.DatabaseInterface;
import ru.gb.socialnet.domain.UserProfile;
import ru.gb.socialnet.domain.UserProfileBuilder;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserProfileRepository implements CrudRepository<UserProfile, Long>, DatabaseInterface {

    private final DatabaseHandler dbh;
    private final Connection conn;
    private UserProfileBuilder userBuilder;
    private PreparedStatement psFindById;

    public UserProfileRepository(DatabaseHandler dbh) {
        this.dbh = dbh;
        this.conn = dbh.getConnection();
        this.userBuilder = new UserProfileBuilder();
        try {
            psFindById = conn.prepareStatement("SELECT id, fname, lname, nickname, sex, dob" +
                    " FROM socialnetwork.userprofile WHERE id = ?;");
        } catch (SQLException th) {
            th.printStackTrace();
        }
    }

    @Override
    public Optional<UserProfile> findById(Long aLong) {
        try {
            psFindById.setLong(1, aLong);
            ResultSet rs = psFindById.executeQuery();
            if (rs.next()) {
                this.userBuilder = new UserProfileBuilder();
                userBuilder.setId(rs.getLong(1));
                userBuilder.setFName(rs.getString(2));
                userBuilder.setLName(rs.getString(3));
                userBuilder.setNickName(rs.getString(4));
                userBuilder.setDob(rs.getDate(6));
                userBuilder.setSex(rs.getString(5));
                rs.close();
                return Optional.of(userBuilder.getResult());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
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
            psFindById.close();
            dbh.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
