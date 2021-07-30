package me.imaginedev.punishmentsx.punishment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public abstract class Punishment {
    public abstract PunishmentType getType();

    private @Getter final String enforcer;

    /**
     * Apply a punishment to the player with the provided reason.
     *
     * @param player the player
     * @param reason the reason
     */
    public void applyPunishment(Player player, @Nullable String reason) {}
}