package me.imaginedev.punishmentsx.config;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * Converted to `messages.yml` at runtime.
 */
@Getter
public class Messages {
    // Lists for when the player is disconnected.
    private final List<String> kickedMessage = Arrays.asList("&4&lYou've been kicked from this server!", "&cReason: &n%reason%");
    private final List<String> bannedMessage = Arrays.asList("&4&lYou've been banned from this server!", "&rReason: &n%reason%", "&cDuration: &f&n%duration%");

    // Chat messages.
    private final String warnedMessage = "&6&lYou've been warned for &n%reason%";
    private final String mutedMessage = "&3&lYou've been muted! Reason: &7&n%reason%&3&l, Duration: &7&n%duration%";

    // Command responses.
    private final String noPermission = "&4You don't have permission!";
    private final String notAPlayer = "&cThat player cannot be found!";

    private final String bannedPlayer = "&2Successfully banned player &n%player%&2!";
    private final String warnedPlayer = "&2Successfully warned player &n%player%&2!";
    private final String kickedPlayer = "&2Successfully kicked player &n%player%&2!";
    private final String mutedPlayer = "&2Successfully muted player &n%player%&2!";
}