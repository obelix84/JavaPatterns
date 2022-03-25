package ru.gb.socialnet.repository;

import ru.gb.socialnet.domain.Channel;

import java.util.HashMap;
import java.util.Map;

public class ChannelIdentityMap {

    private static ChannelIdentityMap instance = new ChannelIdentityMap();
    private Map<Long, Channel> channelMap= new HashMap<>();

    public static Channel get(long id) {
        return instance.channelMap.get(id);
    }

    public static void add(Channel channel) {
        instance.channelMap.put(channel.getId(), channel);
    }

}
