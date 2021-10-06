package weapons.damage;

import org.bukkit.inventory.ItemStack;
import utils.CanIntegered;
import utils.GetNBTTagUsingKey;

public class GetWeaponStr {
    public static double get(ItemStack stack) {
        String str = GetNBTTagUsingKey.get(stack, "str");
        if(!CanIntegered.check(str)) return 0;

        double value = Integer.parseInt(str);
        return value;
    }
}
