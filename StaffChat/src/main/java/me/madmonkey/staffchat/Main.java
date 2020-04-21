package me.madmonkey.staffchat;

import me.madmonkey.staffchat.Commands.StaffChatCommand;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    public void onEnable(){
        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand());
        getLogger().info("StaffChat has been Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffChat has been Disabled!");
    }
}
