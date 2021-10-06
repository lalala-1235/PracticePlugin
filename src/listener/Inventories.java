package listener;

import cosmetics.SummonCosmetics;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;

public class Inventories implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        System.out.println(e.getInventory().getSize());
        if(e.getInventory().getSize() != 9) return;

        e.setCancelled(true);

        ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null || clickedItem.getType().isAir()) return;

        Player p = (Player) e.getWhoClicked();

        switch(e.getRawSlot()) {
            case(0):
                SummonCosmetics.summonFlag(p);
                p.closeInventory();
                break;
            default:
                p.closeInventory();
                break;
        }

    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().getSize()!=9) {
            e.setCancelled(true);
        }
    }
}
