package me.guwooing.chatchannels;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChannelManager {

    private Map<UUID, Channel> playerChannels = new HashMap<>();

    public void setChannel(UUID uuid, Channel channel) {
        this.playerChannels.put(uuid, channel);
    }

    public Channel getChannel(UUID uuid) {
        if (!this.playerChannels.containsKey(uuid)) {
            setChannel(uuid, Channel.GLOBAL);
        }
        return this.playerChannels.get(uuid);
    }
}
