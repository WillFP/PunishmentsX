package me.imaginedev.punishmentsx.sql;

import me.imaginedev.punishmentsx.punishment.Punishment;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.function.Consumer;

public class SQLManager {
    private final Map<UUID, List<Punishment>> punishments = new HashMap<>();

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
        return punishments.get(player.getUniqueId());
    }

    /**
     * Add a punishment or get an existing one from a player.
     *
     * @param player the player
     * @param punishment the default punishment
     *
     * @return the punishment
     */
    public Punishment addOrGet(Player player, Punishment punishment) {
        List<Punishment> punishments = getPunishments(player);
        Optional<Punishment> optional = punishments.stream().filter(punishment::equals).findFirst();

        if (!optional.isPresent()) punishments.add(punishment);
        else punishment = optional.get();

        return punishment;
    }

    /**
     * Whether or not to block a player from joining.
     *
     * @param player the player
     * @param consumer the consumer
     */
    public void isBlockJoin(Player player, Consumer<Punishment> consumer) {
        Punishment punishment = punishments.get(player.getUniqueId()).stream()
            .filter(Punishment::blocksJoin)
            .findFirst().orElse(null);

        consumer.accept(punishment);
    }
}