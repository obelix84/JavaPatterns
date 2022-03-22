package ru.gb.socialnet.service;

import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.domain.Channel;
import ru.gb.socialnet.domain.UserProfile;
import ru.gb.socialnet.repository.ChanelRepository;

import java.util.ArrayList;
import java.util.List;

public class ChannelService {
    private final DatabaseHandler dbh;
    private final ChanelRepository channelRepo;

    public ChannelService(DatabaseHandler dbh) {
        this.dbh = dbh;
        this.channelRepo = new ChanelRepository(dbh);
    }

    public List<Channel> findAll() {
        return channelRepo.findAll();
    }
}
