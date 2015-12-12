package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.COOWNER;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.MOWNER;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.LEADDEV;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.STAFFMNGER;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.HEADADM;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.TF_DEVELOPERS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    TF_DEVELOPER("a " + ChatColor.DARK_PURPLE + "TotalFreedom Developer", ChatColor.translateAlternateColorCodes('&', "&8[&5TF&7-&5Dev&8]&9")),
    MODERATORS("a " + ChatColor.GOLD + "Moderator", ChatColor.translateAlternateColorCodes('&', "&8[&6Moderator&8]&9")),
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.translateAlternateColorCodes('&', "&8[&5Dev&8]&9")),
    IMPOSTOR("an " + ChatColor.YELLOW + ChatColor.UNDERLINE + "Impostor", ChatColor.translateAlternateColorCodes('&', "&8[&e&nIMP&8]&9")),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    OP("an " + ChatColor.RED + "OP", ChatColor.translateAlternateColorCodes('&', "&8[&cOP&8]&9")),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.translateAlternateColorCodes('&', "&8[&bSuper Admin&8]&9")),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.translateAlternateColorCodes('&', "&8[&2Telnet Admin&8]&9")),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin",ChatColor.translateAlternateColorCodes('&', "&8[&dSenior Admin&8]&9")),
    OWNER("the " + ChatColor.DARK_RED + "Founder " + ChatColor.AQUA + "of " + ChatColor.RED + "iRedemptFreedom", ChatColor.translateAlternateColorCodes('&', "&8[&4Founder&8]&9")),
    SYS_ADMIN("a " + ChatColor.DARK_RED + "System-Admin",ChatColor.translateAlternateColorCodes('&', "&8[&4System Admin&8]&9")),
    LEAD_DEVELOPER("the " + ChatColor.DARK_PURPLE + "Lead Developer" + ChatColor.AQUA + " of " + ChatColor.RED + "iRedemptFreedom", ChatColor.translateAlternateColorCodes('&', "&8[&5L&7-&5Dev&8]&9")),
    EXEC("an " + ChatColor.YELLOW + "Executive", ChatColor.translateAlternateColorCodes('&', "&8[&eExecutive&8]&9")),
    CO_OWNER("a " + ChatColor.BLUE + "Co-Owner" + ChatColor.AQUA + " of " + ChatColor.RED + "iRedemptFreedom", ChatColor.translateAlternateColorCodes('&', "&8[&9Co&7-&9Owner&8]&9")),
    CHAR("the " + ChatColor.DARK_PURPLE + "Co-Chief Forum Developer", ChatColor.translateAlternateColorCodes('&', "&8[&5CCFD&8]&9")),
    MFOUNDER("the " + ChatColor.DARK_RED + "Main Founder" + ChatColor.AQUA + " of " + ChatColor.RED + "iRedemptFreedom", ChatColor.translateAlternateColorCodes('&', "&8[&4Main Founder&8]&9")),    
    HADMIN("the " + ChatColor.YELLOW + "Head Admin" + ChatColor.AQUA + " of " + ChatColor.RED + "iRedemptFreedom", ChatColor.translateAlternateColorCodes('&', "&8[&eHead Admin&8]&9")),
    STAFFMANAGE("the " + ChatColor.RED + "Staff Manager" + ChatColor.AQUA + " of " + ChatColor.RED + "iRedemptFreedom", ChatColor.translateAlternateColorCodes('&', "&8[&cStaff Manager&8]&9")),
    CONSOLE("the " + ChatColor.DARK_PURPLE + "Console", ChatColor.translateAlternateColorCodes('&', "&8[&5Console&8]&9"));
    private final String loginMessage;
    private final String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }


        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }

        else if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }

        else if (SYS.contains(sender.getName()))
        {
            return SYS_ADMIN;
        }

        else if (COOWNER.contains(sender.getName()))
        {
            return CO_OWNER;
        }
        else if (MOWNER.contains(sender.getName()))
        {
            return MFOUNDER;
        }
        else if (STAFFMNGER.contains(sender.getName()))
        {
            return STAFFMANAGE;
        }
        else if (LEADDEV.contains(sender.getName()))
        {
            return LEAD_DEVELOPER;
        }
        else if (HEADADM.contains(sender.getName()))
        {
            return HADMIN;
        }        

        final TFM_Admin entry = TFM_AdminList.getEntryByIp(TFM_Util.getIp((Player) sender));

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }
            if (TFM_ConfigEntry.SERVER_MODERATORS.getList().contains(sender.getName()))
            {
                return MODERATORS;
            }
            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {
                rank = SUPER;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}
