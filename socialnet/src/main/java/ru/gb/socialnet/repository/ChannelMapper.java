package ru.gb.socialnet.repository;

import ru.gb.socialnet.domain.Channel;

import java.sql.*;


public class ChannelMapper {

    private final Connection connection;

    public ChannelMapper(Connection connection) {
        this.connection = connection;
    }

    public Channel findById(long id) throws SQLException {
        PreparedStatement psFindById = connection.prepareStatement(
                "SELECT id, name, creation_date " +
                " FROM socialnetwork.channels WHERE id = ?;");
        psFindById.setLong(1, id);
        ResultSet rs = psFindById.executeQuery();
        Channel channel = null;
        if (rs.next()) {
            channel = new Channel();
            channel.setId(rs.getLong(1));
            channel.setName(rs.getString(2));
            channel.setCreationDate(rs.getDate(3));
        }
        rs.close();
        return channel;
    }

    public void delete(Channel channel) throws SQLException {
        PreparedStatement psDeleteById = connection.prepareStatement(
                "DELETE FROM socialnetwork.channels WHERE id = ?;");
        psDeleteById.setLong(1, channel.getId());
    }

    public void insert(Channel channel) throws SQLException {
        PreparedStatement psInsertChannel = connection.prepareStatement(
                "INSERT INTO socialnetwork.channels (id, name, creation_date) " +
                        "VALUES (?, ?, ?)");
        psInsertChannel.setLong(1, channel.getId());
        psInsertChannel.setString(2, channel.getName());
        //вот тут не хорошо с датами... но успростим...
        psInsertChannel.setDate(3, (Date) channel.getCreationDate());
        psInsertChannel.executeUpdate();
    }
    public void update(Channel channel) throws SQLException {
        PreparedStatement psUpdateChannel = connection.prepareStatement(
                "UPDATE socialnetwork.channels SET name = ?, creation_date = ? WHERE id = ?");
        psUpdateChannel.setString(2, channel.getName());
        psUpdateChannel.setDate(3, (Date) channel.getCreationDate());
        psUpdateChannel.executeUpdate();
    }


}
