package me.imaginedev.punishmentsx.listener;

import lombok.RequiredArgsConstructor;
import me.imaginedev.punishmentsx.punishment.BanPunishment;
import me.imaginedev.punishmentsx.punishment.PunishmentType;
import me.imaginedev.punishmentsx.punishment.TemporaryPunishment;
import me.imaginedev.punishmentsx.sql.SQLManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

@RequiredArgsConstructor
public class PlayerEventListener implements Listener {
    private final SQLManager manager;

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        TemporaryPunishment punishment = manager.getActivePunishment(event.getPlayer(), PunishmentType.MUTE);
        if (punishment != null && punishment.isActive()) event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        manager.isBlockJoin(event.getUniqueId(), punishment -> {
            if (punishment != null && punishment.isActive()) {
                event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, ((BanPunishment) punishment).getBanList());
            }
        });
    }
}