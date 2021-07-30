package me.imaginedev.punishmentsx;

import me.imaginedev.galaxyapi.GalaxyCore;
import me.imaginedev.punishmentsx.api.PunishmentsXAPI;
import me.imaginedev.punishmentsx.command.BanCommand;
import me.imaginedev.punishmentsx.command.KickCommand;
import me.imaginedev.punishmentsx.config.Messages;
import me.imaginedev.punishmentsx.listener.PlayerEventListener;
import me.imaginedev.punishmentsx.sql.SQLManager;

public final class PunishmentsX extends GalaxyCore {
    @Override
    public void onEnable() {
        Messages messages = new Messages();
        setConfigClassValues(messages);

        SQLManager manager = new SQLManager();
        Runnable runnable = manager::queryPunishments;

        getServer().getScheduler().runTaskLaterAsynchronously(this, runnable, 0);

        new PunishmentsXAPI(messages);

        registerCommands(messages, manager);
        getServer().getPluginManager().registerEvents(new PlayerEventListener(manager), this);
    }

    private void registerCommands(Messages messages, SQLManager manager) {
        getCommand("ban").setExecutor(new BanCommand(messages, manager));
        getCommand("kick").setExecutor(new KickCommand(messages, manager));
    }
}