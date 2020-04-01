package me.guwooing.chatchannels;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListner implements Listener {

    private ChatChannels plugin;

    public ChatListner(ChatChannels plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        e.setCancelled(true);

        Channel channel = plugin.getChannelManager().getChannel(player.getUniqueId());
        String format = Utils.chat(channel.getFormat().replace("<player>", player.getName().replace("<message>", e.getMessage())));

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (channel.getPermission().equals("")) {
                p.sendMessage(format);
            } else if (p.hasPermission(channel.getPermission())) {
                p.sendMessage(format);
            }
        }
    }
}
