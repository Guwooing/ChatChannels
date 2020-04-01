package me.guwooing.chatchannels;

import org.bukkit.ChatColor;

public class Utils {

    //allows color codes to start with '&'
    public static String chat (String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
