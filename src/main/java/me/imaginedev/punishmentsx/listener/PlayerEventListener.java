package me.imaginedev.punishmentsx.listener;

import lombok.RequiredArgsConstructor;
import me.imaginedev.punishmentsx.punishment.BanPunishment;
import me.imaginedev.punishmentsx.sql.SQLManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

@RequiredArgsConstructor
public class PlayerEventListener implements Listener {
    private final SQLManager manager;

    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent event) {
        manager.isBlockJoin(event.getPlayer(), punishment -> {
            if (!(punishment instanceof BanPunishment)) return;

            event.disallow(PlayerLoginEvent.Result.KICK_BANNED, ((BanPunishment) punishment).getBanList());
        });
    }
}