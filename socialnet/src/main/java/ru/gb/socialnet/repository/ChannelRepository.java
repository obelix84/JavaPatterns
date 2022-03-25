package ru.gb.socialnet.repository;


import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.db.DatabaseInterface;
import ru.gb.socialnet.domain.Channel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChannelRepository implements CrudRepository<Channel, Long>, DatabaseInterface {

    private final DatabaseHandler dbh;
    private final Connection conn;
    private final ChannelMapper channelMapper;

    public ChannelRepository(DatabaseHandler dbh) {
        this.dbh = dbh;
        this.conn = dbh.getConnection();
        this.channelMapper = new ChannelMapper(this.conn);
    }

    @Override
    public Optional<Channel> findById(Long id) {
        Channel channel = ChannelIdentityMap.get(id);
        if (channel == null) {
            System.out.println("from DB");
            try {
                channel = channelMapper.findById(id);
            } catch (SQLException th) {
                th.printStackTrace();
            }
            if (channel != null) {
                ChannelIdentityMap.add(channel);
                return Optional.of(channel);
            }
            return Optional.empty();
        } else {
            System.out.println("from identityMap");
            return Optional.of(channel);
        }
    }

    @Override
    public <S extends Channel> S save(S entity) {
        return null;
    }

    @Override
    public void delete(Channel entity) {

    }

    @Override
    public void disconnect() {
        dbh.disconnect();
    }
}
