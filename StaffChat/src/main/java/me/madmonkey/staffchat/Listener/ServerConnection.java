package me.madmonkey.staffchat.Listener;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerConnection implements Listener {

    @EventHandler
    public void onServerChange(ServerConnectedEvent event){
        ProxiedPlayer player = event.getPlayer();
        for(ProxiedPlayer everyone : ProxyServer.getInstance().getPlayers()){
            if(everyone.hasPermission("madstaffchat.use")){
                everyone.sendMessage(new TextComponent(ChatColor.AQUA + "[S]" + player.getDisplayName() + ChatColor.BLUE + "connected to" + ChatColor.AQUA + event.getServer()));
            }
        }
    }
}
