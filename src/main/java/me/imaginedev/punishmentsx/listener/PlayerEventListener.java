package me.imaginedev.punishmentsx.listener;

import lombok.RequiredArgsConstructor;
import me.imaginedev.punishmentsx.sql.SQLManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@RequiredArgsConstructor
public class PlayerEventListener implements Listener {
    private final SQLManager manager;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        manager.doBlockJoin(event.getPlayer(), punishment -> {
            if (punishment == null) return;

            punishment.applyPunishment(event.getPlayer());
        });
    }
}