package ability;

import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;

public class SetCooldown {
    public static void cooldown(Player p, int time) {
        EntityPlayer entityp = ((CraftPlayer) p).getHandle();
        net.minecraft.server.v1_16_R3.ItemStack nmsitem = CraftItemStack.asNMSCopy(p.getItemInHand());

        entityp.getCooldownTracker().setCooldown(nmsitem.getItem(), time);
    }
}
