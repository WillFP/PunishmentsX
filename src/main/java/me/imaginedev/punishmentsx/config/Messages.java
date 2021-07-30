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
    private final List<String> kickedMessage = Arrays.asList("&4&lYou've been kicked from this server!", "&rReason: &n%reason%");

    // Chat messages.
    private final String warnedMessage = "&6&lYou've been warned! Reason: &n%reason%";

    // Default reasons.
    private final String bannedReason = "&cYou are banned from this server!";
}