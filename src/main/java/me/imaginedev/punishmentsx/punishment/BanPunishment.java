package me.imaginedev.punishmentsx.punishment;

import lombok.Getter;
import me.imaginedev.galaxyapi.util.MessageUtil;
import me.imaginedev.punishmentsx.api.PunishmentsXAPI;
import me.imaginedev.punishmentsx.config.Messages;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.stream.Collectors;

@Getter
public class BanPunishment extends Punishment {
    private final BanList.Type type;
    private final String enforcer;

    private final String banList;

    public BanPunishment(BanList.Type type, String enforcer) {
        super(enforcer);

        this.type = type;
        this.enforcer = enforcer;

        Messages messages = PunishmentsXAPI.getInstance().getMessages();

        banList = messages.getBannedMessage().stream()
            .map(MessageUtil::color)
            .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public boolean blocksJoin() {
        return true;
    }

    @Override
    protected void apply(Player player, String reason) {
        Bukkit.getBanList(type).addBan(player.getName(), reason, null, enforcer);
    }
}