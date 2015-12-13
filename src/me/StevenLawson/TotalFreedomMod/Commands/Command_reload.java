package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Kicks everyone and reloads the server.", usage = "/<command>", aliases = "rl")
public class Command_reload extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.bcastMsg("Server is reloading. Please wait...", ChatColor.LIGHT_PURPLE);

        server.reload();
        TFM_Util.adminAction(sender.getName(), "Disconnecting all players.", true);

        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.kickPlayer(ChatColor.LIGHT_PURPLE + "[CakeFreedom!] " + ChatColor.WHITE + "You have been kicked by " + sender.getName() + " because of a server reload. Please relogin.");
        }
        return true;
    }
}
