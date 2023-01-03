package me.HALD91.Weaponkit.Bow;

import me.HALD91.Weaponkit.Gui.Listener;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;

public class MultiBow extends Listener {
    @EventHandler
    public void multibow(EntityShootBowEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            Entity proj = e.getProjectile();
            if(proj == null) return;
            /*
            Vector playerDirection = p.getLocation().getDirection();
            EntityAr arrow = ((CraftArrow) this.player.launchProjectile(Arrow.class, playerDirection)).getHandle();
            arrow.fromPlayer = 0;
            */
        }
    }
}
