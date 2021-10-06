package cosmetics;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SummonCosmetics {

    public static void summonFlag(Player p) {
        Location loc = p.getLocation();

        Location particleLoc1 = loc;

        Vector v = particleLoc1.getDirection();
        v = v.multiply(3);

        particleLoc1 = particleLoc1.add(v);

        Particle.DustOptions dust = new Particle.DustOptions(Color.BLACK, 2.2f);
        Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 1.5f);


        //깃발대
        loc.getWorld().spawnParticle(Particle.REDSTONE, particleLoc1.getX(), particleLoc1.getY() + 1, particleLoc1.getZ(),100, 0,0.75,0, dust);

        //대충 깃발 만드는 과정
        Location spawnLoc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());

        Entity entity = spawnLoc.getWorld().spawnEntity(spawnLoc, EntityType.ARMOR_STAND);
        spawnLoc.setYaw(p.getLocation().getYaw() + 90); // spawnLoc에 yaw 값 부여 - 플레이어 yaw에서 90도만큼 돌림(깃발 방향)
        entity.setInvulnerable(true); //대충 설정들
        entity.setGravity(false);
        ((CraftArmorStand) entity).getHandle().setInvisible(true);
        entity.teleport(spawnLoc); // yaw값을 부여한 spawnLoc으로 teleport시킴.


        for(int i = 10; i < 25; i++) {
            double yloc = i;
            yloc = yloc/10;

            Location newLoc = new Location(spawnLoc.getWorld(), loc.getX(), loc.getY() + yloc, loc.getZ()); // 깃발 y값 조정
            newLoc.setYaw(p.getLocation().getYaw() + 90);
            entity.teleport(newLoc);
            entity = Bukkit.getEntity(entity.getUniqueId());

            for(int j = 1; j < i; j++) {
                double multiplier2 = j;
                multiplier2 = multiplier2/10;

                Location particleLoc = entity.getLocation(); // 파티클이 소환될 위치

                Vector tempV = particleLoc.getDirection();
                tempV.multiply(multiplier2); //벡터 길이 조정
                particleLoc.add(tempV); // 소환될 좌표

                particleLoc.getWorld().spawnParticle(Particle.REDSTONE, particleLoc.getX(), particleLoc.getY(), particleLoc.getZ(),5, 0,0,0, dust2);
            }

        }

        ((CraftArmorStand) entity).getHandle().setHealth(0);//아머스탠드 제거

    }
}
