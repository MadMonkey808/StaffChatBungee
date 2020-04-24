package me.madmonkey.staffchat;

import me.madmonkey.staffchat.Commands.StaffChatCommand;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends Plugin {

    public static List<ProxiedPlayer> inSc = new ArrayList<>();

    public void onEnable(){
        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand());
        getLogger().info("StaffChat has been Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffChat has been Disabled!");
    }
}
