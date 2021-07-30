package me.imaginedev.punishmentsx.sql;

import me.imaginedev.punishmentsx.punishment.Punishment;
import me.imaginedev.punishmentsx.punishment.PunishmentType;
import me.imaginedev.punishmentsx.punishment.TemporaryPunishment;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.function.Consumer;

/**
 * SQL and player punishment manager class.
 */
public class SQLManager {
    private final Map<UUID, List<Punishment>> punishmentMap = new HashMap<>();

    /**
     * Query and get the SQL data.
     */
    public void queryPunishments() {
        // TODO add punishment SQL system.
    }

    /**
     * Get the punishments for a player.
     *
     * @param player the player
     * @return the punishments
     */
    public List<Punishment> getPunishments(Player player) {
        return punishmentMap.get(player.getUniqueId());
    }

    /**
     * Get an active punishment for a player.
     *
     * @param player the player
     * @param punishmentType the punishment type to match
     *
     * @return the punishment, or null if there is not one active
     */
    public TemporaryPunishment getActivePunishment(Player player, PunishmentType punishmentType) {
        for (Punishment punishment : getPunishments(player)) {
            if (punishment.getType() == punishmentType && punishment instanceof TemporaryPunishment) {
                TemporaryPunishment temp = (TemporaryPunishment) punishment;
                if (temp.isActive()) return temp;
            }
        }
        return null;
    }

    /**
     * Add a punishment to a player.
     *
     * @param player the player
     * @param punishment the punishment
     */
    public void addPunishment(OfflinePlayer player, Punishment punishment) {
        List<Punishment> punishments = punishmentMap.get(player.getUniqueId());
        if (punishments == null) punishments = new ArrayList<>();

        punishments.add(punishment);
    }

    /**
     * Whether or not to block a player from joining.
     *
     * @param player the player uuid
     * @param consumer the consumer
     */
    public void isBlockJoin(UUID player, Consumer<TemporaryPunishment> consumer) {
        for (Punishment punishment : punishmentMap.get(player)) {
            if (punishment.getType() == PunishmentType.BAN || punishment.getType() == PunishmentType.IP_BAN) {
                TemporaryPunishment temporaryPunishment = (TemporaryPunishment) punishment;

                if (temporaryPunishment.isActive()) {
                    consumer.accept(temporaryPunishment);
                    return;
                }
            }
        }
        consumer.accept(null);
    }
}