package ru.gb.socialnet.repository;


import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.db.DatabaseInterface;
import ru.gb.socialnet.domain.Channel;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChanelRepository implements CrudRepository<Channel, Long>, DatabaseInterface {

    private final DatabaseHandler dbh;
    private final Connection conn;


    public ChanelRepository(DatabaseHandler dbh) {
        this.dbh = dbh;
        this.conn = dbh.getConnection();
    }


    @Override
    public Optional<Channel> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public <S extends Channel> S save(S entity) {
        return null;
    }

    @Override
    public void delete(Channel entity) {

    }

    public List<Channel> findAll() {
        List<Channel> channels = new ArrayList<>();
        channels.add(new Channel("Channel1"));
        channels.add(new Channel("Channel2"));
        channels.add(new Channel("Channel3"));
        return channels;
    }


    @Override
    public void disconnect() {
        dbh.disconnect();
    }
}
