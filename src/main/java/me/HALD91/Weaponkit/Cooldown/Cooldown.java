package me.HALD91.Weaponkit.Cooldown;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class Cooldown {
    private static Table<String, String, Long> cooldowns = HashBasedTable.create();

    public static long getCooldown(Player player, String key) {
        return calculateRemainder((Long) cooldowns.get(player.getName(), key));
    }

    public static long setCooldown(Player player, String key, long delay) {
        return calculateRemainder((Long) cooldowns.put(player.getName(), key, Long.valueOf(System.currentTimeMillis() + delay)));
    }

    public static boolean tryCooldown(Player player, String key, long delay) {
        if (getCooldown(player, key) <= 0L) {
            setCooldown(player, key, delay);
            return true;
        }
        return false;
    }

    private static long calculateRemainder(Long expireTime) {
        if (expireTime != null) {
            long currentTime = System.currentTimeMillis();
            long remainingTimeMillis = expireTime - currentTime;
            long remainingTimeMinutes = TimeUnit.MILLISECONDS.toMinutes(remainingTimeMillis);
            return remainingTimeMinutes;
        } else {
            return Long.MIN_VALUE;
        }
    //return (expireTime != null) ? (expireTime.longValue() - System.currentTimeMillis()) : Long.MIN_VALUE;
    }
}