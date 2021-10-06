package gui;

import cosmetics.SummonCosmetics;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIGeneratorForCosmetics{
    private final Inventory inv;

    // one line
    public GUIGeneratorForCosmetics(){
        inv = Bukkit.createInventory(null, 9, "COSMETICS");

        initializeItems();
    }

    public void initializeItems() {
        ItemStack banner = new ItemStack(Material.RED_BANNER);
        ItemMeta bannermeta = banner.getItemMeta();
        bannermeta.setDisplayName("FLAG");
        banner.setItemMeta(bannermeta);

        inv.addItem(banner);
    }

    public void openInventory(Player p) {
        p.openInventory(inv);
    }

}
