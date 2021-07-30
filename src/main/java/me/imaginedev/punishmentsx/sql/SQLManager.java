package me.imaginedev.punishmentsx.sql;

import me.imaginedev.punishmentsx.punishment.Punishment;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.function.Consumer;

public class SQLManager {
    private final Map<UUID, List<Punishment>> punishments = new HashMap<>();

    public void queryPunishments() {
        // TODO add punishment SQL system.
    }

    public List<Punishment> getPunishments(Player player) {
        return punishments.get(player.getUniqueId());
    }

    public void doBlockJoin(Player player, Consumer<Punishment> consumer) {
        Punishment punishment = punishments.get(player.getUniqueId()).stream()
            .filter(Punishment::blocksJoin)
            .findFirst().orElse(null);

        consumer.accept(punishment);
    }
}