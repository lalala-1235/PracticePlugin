package weapons.damage;

import org.bukkit.inventory.ItemStack;
import utils.RandomNumGen;

// str = 해당 값만큼 베이스 데미지 증가(%) critDamage = 해당 값만큼 베이스 데미지 증가(%) critChance = 크리티컬 터질 확률(%)
// baseDamage = 무기의 기본 데미지 damageMultiplier = 데미지 증폭 수치
public class DamageCalculator {
    public static double calculator(double strength, double critDamage,int critChance,double baseDamage,double damageMultiplier, ItemStack stack) {
        double weaponStr = GetWeaponStr.get(stack);
        strength = strength + weaponStr;
        // System.out.println("str: " + weaponStr);

        // System.out.println("baseDmg: " + baseDamage); //debug
        double calculated = baseDamage * (strength/100 + 1);
        calculated = (Math.round(calculated * 100) / 100.0);
        // System.out.println("str added: " + calculated); //debug

        boolean crithit = RandomNumGen.numberGenerator(critChance);
        if(crithit) calculated = calculated * (critDamage/100 + 1);
        calculated = (Math.round(calculated * 100) / 100.0);
        // System.out.println("critdmg added: " + calculated); //debug

        calculated = calculated * (damageMultiplier/100 + 1);
        calculated = (Math.round(calculated * 100) / 100.0);

        return calculated;

    }
}

