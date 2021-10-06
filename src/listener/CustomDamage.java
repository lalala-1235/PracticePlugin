package listener;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import weapons.damage.DamageCalculator;

public class CustomDamage implements Listener {
    @EventHandler
    public void onEntityHitByPlayer(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        if(!(e.getEntity() instanceof LivingEntity)) return;

        Player damager = (Player) e.getDamager();
        LivingEntity damagedEntity = (LivingEntity) e.getEntity();
        double damagedEntityPrevious = (Math.round(damagedEntity.getHealth() * 100)) / 100;
        double baseDamage = e.getDamage();
        double modifiedDamage = DamageCalculator.calculator(0, 0, 100, baseDamage, 0, damager.getInventory().getItemInMainHand());
        e.setDamage(modifiedDamage);
        damager.sendMessage(modifiedDamage + "만큼 데미지를 입혔습니다!");
        if((damagedEntityPrevious - modifiedDamage) < 0) damager.sendMessage(damagedEntityPrevious + "->" + 0);
        else damager.sendMessage(damagedEntityPrevious + "->" + (damagedEntityPrevious - modifiedDamage));


    }
}
