package listener;

import ability.Ability;
import ability.SetCooldown;
import cosmetics.SummonCosmetics;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import utils.CanIntegered;
import utils.GetItemAbiltyCode;

public class OnRightClickAir implements Listener{
    @EventHandler
    public void onRightClick(PlayerInteractEvent e)  {
        if(e.getAction()!= Action.RIGHT_CLICK_AIR) return;

        Player p = e.getPlayer();
        if(p.getInventory().getItemInMainHand().equals(new ItemStack(Material.AIR))) return;
        net.minecraft.server.v1_16_R3.ItemStack nmsitem = CraftItemStack.asNMSCopy(p.getInventory().getItemInMainHand());
        EntityPlayer entityp = ((CraftPlayer) p).getHandle();
        if(entityp.getCooldownTracker().hasCooldown(nmsitem.getItem())) return;

        String abilityCode = GetItemAbiltyCode.get(p.getInventory().getItemInMainHand());
        if(!CanIntegered.check(abilityCode)) return;

        int intCode = Integer.parseInt(abilityCode);

        switch(intCode) {
            case(1):
                Ability.teleportToFacing(p, 5);
                SetCooldown.cooldown(p, 10);
                break;

            case(2):
                SummonCosmetics.summonFlag(p);
                SetCooldown.cooldown(p, 30);
                break;

            default:
                break;
        }

    }

}
