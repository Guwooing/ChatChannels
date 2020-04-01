package me.guwooing.chatchannels;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChatChannels extends JavaPlugin {

    private ChannelManager channelManager;

    public void onEnable() {
        getCommand("chat").setExecutor(new ChatCommand(this));
        getServer().getPluginManager().registerEvents(new ChatListner(this), this);
        this.channelManager = new ChannelManager();
    }

    public ChannelManager getChannelManager() {
        return channelManager;
    }
}
