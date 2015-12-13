package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "See how to become admin.", aliases = "ai", usage = "/<command>")
public class Command_admininfo extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        
     if (!TFM_AdminList.isSuperAdmin(sender_p)) {   
        sender_p.chat("I'm going to apply for administrator!");
        sender_p.chat("Hopefully, I'll get accepted by a Owner or a Developer!");
        TFM_Util.playerMsg(sender_p, "Apply Here:", ChatColor.BLUE);
        TFM_Util.playerMsg(sender_p, "http://cakefreedom.boards.net/", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "Objection means that you did something bad!", ChatColor.RED);
        TFM_Util.playerMsg(sender_p, "Vouch means that an admin likes you,\nand your application!", ChatColor.GREEN);
     }
        
        if (TFM_AdminList.isSuperAdmin(sender_p)) {
         
            String url = "https://cakefreedom.boards.net";
            playerMsg(ChatColor.RED + "You're an admin, you cannot apply");
            playerMsg(ChatColor.GOLD + "But you can still view our forums\nURL: " + url);
            playerMsg(ChatColor.BLUE + "You can also apply for a promotion!\n");
         
            
        }
        
        return true;
    }
}
