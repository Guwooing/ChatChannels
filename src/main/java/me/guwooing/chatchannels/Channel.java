package me.guwooing.chatchannels;

public enum Channel {

    GLOBAL("", "g", "[G] <player>: <message>"), STAFF("chatchannels.staff", "s", "[S] <player>: <message>");

    private String permission, alias, format;

    Channel(String permission, String alias, String format) {
        this.permission = permission;
        this.alias = alias;
        this.format = format;
    }

    public String getPermission() {
        return permission;
    }

    public String getFormat() {
        return format;
    }

    public String getAlias() {
        return alias;
    }

    public static Channel getChannel(String c) {
        Channel channel = null;
        try {
            channel = Channel.valueOf(c.toUpperCase());
        } catch (IllegalArgumentException e) {
            for (Channel ch : Channel.values()) {
                if (ch.getAlias().equalsIgnoreCase(c)) {
                    return ch;
                }
            }
        }
        return channel;
    }
}
