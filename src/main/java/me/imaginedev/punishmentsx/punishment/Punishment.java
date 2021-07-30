package me.imaginedev.punishmentsx.punishment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

@AllArgsConstructor
@Getter
public abstract class Punishment {
    public abstract boolean blocksJoin();
    public abstract void apply(Player player, String reason);

    protected String getDefaultReason() {
        return "";
    }

    /**
     * Apply a punishment to the player with the provided reason.
     *
     * @param player the player
     * @param reason the reason
     */
    public final void applyPunishment(Player player, String reason) {
        this.apply(player, reason);
    }

    /**
     * Apply a punishment to the player with the default reason.
     *
     * @param player the player
     */
    public final void applyPunishment(Player player) {
        this.apply(player, getDefaultReason());
    }
}