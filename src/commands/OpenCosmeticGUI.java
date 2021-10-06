package commands;

import cosmetics.SummonCosmetics;
import gui.GUIGeneratorForCosmetics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenCosmeticGUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return false;

        GUIGeneratorForCosmetics gui = new GUIGeneratorForCosmetics();
        gui.openInventory((Player)commandSender);

        return true;
    }
}
