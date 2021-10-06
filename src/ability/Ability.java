package ability;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Ability {
    public static void teleportToFacing(Player p, int distance) {
        Location loc = p.getLocation();
        Vector v = loc.getDirection();
        v = v.multiply(distance);

        loc = loc.add(v);
        p.teleport(loc);
    } //code 1
}
