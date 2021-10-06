package utils;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class GetNBTTagUsingKey {
    public static String get(ItemStack stack, String key) {
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(stack);
        if(!nmsItem.hasTag()) return "none";

        NBTTagCompound tag = nmsItem.getTag();
        if(!tag.hasKey(key)) return "none";

        String value = tag.get(key).toString();
        return value;
    }
}
