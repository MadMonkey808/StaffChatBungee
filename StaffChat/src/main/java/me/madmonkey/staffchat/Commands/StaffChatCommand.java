package me.madmonkey.staffchat.Commands;

import me.madmonkey.staffchat.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffChatCommand extends Command {

   String prefix = ChatColor.AQUA + "[S]";

    public StaffChatCommand() {
        super("staffchat", "madstaffchat.use", "sc");
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer)sender;
            if (args.length == 0) {
                if (p.hasPermission("bungee.staff")) {
                    if (Main.inSc.contains(p)) {
                        p.sendMessage(new TextComponent(prefix + ChatColor.GREEN + "StaffChat has been disabled!"));
                        Main.inSc.remove(p);
                    } else {
                        Main.inSc.add(p);
                        p.sendMessage(new TextComponent(prefix + ChatColor.GREEN + "StaffChat has been enabled!"));
                    }
                } else {
                    p.sendMessage(new TextComponent(prefix + ChatColor.RED + "You do not have permissions to execute this command!"));
                }
            } else if (p.hasPermission("bungee.staff")) {
                String msg = " ";
                for (int i = 0; i < args.length; i++)
                    msg = String.valueOf(msg) + args[i] + " ";
                for (ProxiedPlayer staff : BungeeCord.getInstance().getPlayers()) {
                    if (staff.hasPermission("bungee.staff"))
                        staff.sendMessage(new TextComponent(prefix + ChatColor.BLUE + "[" + p.getServer().getInfo().getName() + ChatColor.BLUE + "]" + p.getDisplayName() + ChatColor.AQUA + ": " + msg));
                }
            } else {
                p.sendMessage(new TextComponent(prefix + ChatColor.RED + "You do not have permissions to execute this command!"));
            }
        }
    }
}
