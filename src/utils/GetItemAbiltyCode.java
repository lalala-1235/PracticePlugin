package utils;

import net.minecraft.server.v1_16_R3.NBTBase;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class GetItemAbiltyCode {
    public static String get(ItemStack stack) {
        String abilityCode = GetNBTTagUsingKey.get(stack, "ability");
        return abilityCode;
    }
}
