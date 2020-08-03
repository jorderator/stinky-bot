package com.github.jorderator;

import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.event.message.MessageCreateEvent;

public class Commands {

    public static Boolean processCommands(String content, MessageCreateEvent event) {
        if (content.toLowerCase().equals(BotSettings.prefix + "toggle stinky")) {
            BotSettings.stinkyToggle = !BotSettings.stinkyToggle;
            event.getChannel().sendMessage("stinky-detecting toggled to " + (BotSettings.stinkyToggle? "on": "off"));

            BotSettings.updateStatus();

            return true;
        }

        else if (content.toLowerCase().equals(BotSettings.prefix + "invite")) {
            event.getChannel().sendMessage("Invite me to a server with: " + Main.api.createBotInvite());
        }

        return false;
    }

    public static void initialiseBot() {

    }

}
