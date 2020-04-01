package me.guwooing.chatchannels;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.permissions.Permission;

public class ChatCommand implements CommandExecutor {

    private ChatChannels plugin;

    public ChatCommand(ChatChannels plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players may use that command.");
            return true;
        }

        Player player = ((Player) sender);

        if (!player.hasPermission("chatchannels.staff")) {
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(Utils.chat("&cUsage: /chat <channel> <message>"));
            return true;
        }

        Channel channel = Channel.getChannel(args[0]);
        if (channel == null) {
            player.sendMessage(Utils.chat("&cYou provided an invalid channel name: " + args[0]));
            return true;
        }

        if (!channel.getPermission().equals("")) {
            if (!player.hasPermission(channel.getPermission())) {
                player.sendMessage(Utils.chat("&cYou need to permission &7(" + channel.getPermission() + ") &cto use that channel."));
                return true;
            }
        }

        plugin.getChannelManager().setChannel(player.getUniqueId(), channel);
        player.sendMessage(Utils.chat("&aSet your chat channel to &e&l" + channel));
        return true;
    }
}
