package me.madmonkey.staffchat.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffChatCommand extends Command {
    public StaffChatCommand() {
        super("staffchat", "madstaffchat.use", "sc");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(player.hasPermission("madstaffchat.use")){
                if(args.length > 0){
                    String message = "";
                    for(int i= 0; i < args.length; i++){
                        message = message = args[i];
                    }
                    for(ProxiedPlayer all : BungeeCord.getInstance().getPlayers()){
                        if(all.hasPermission("madstaffchat.use")){
                            all.sendMessage(new TextComponent(ChatColor.AQUA + "[S]" + ChatColor.BLUE + "[" + ((ProxiedPlayer) sender).getServer() + "]" + ((ProxiedPlayer) sender).getDisplayName() + ChatColor.AQUA + ":" + message));
                        }
                    }
                } else {
                    player.sendMessage(new TextComponent(ChatColor.RED + "Invalid Message: /sc <message>"));
                }
            }else{
                player.sendMessage(new TextComponent(ChatColor.RED + "You do not have permissions to execute this commands!"));
            }
        }
    }
}
