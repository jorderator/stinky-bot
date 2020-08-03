package com.github.jorderator;

import org.javacord.api.entity.DiscordEntity;
import org.javacord.api.event.message.MessageCreateEvent;

// Class for handling responses to general messages
public class Responses {

    //  Response generating methods
    // Method to handle user-specific responses
    public static void respondToUser(Long userId, MessageCreateEvent event) {
        // example code:
        /*
        if (userId == 000000000000000000L) {
            event.getChannel().sendMessage("hey " + event.getMessageAuthor().getDisplayName() + "... shush nerd");
        }
         */
    }

    // Method for more general message responses, such as elements of text or links, etc
    public static void respondToMessage(String content, MessageCreateEvent event) {
        // example code:
        /*
        if (content.toLowerCase().contains("testing") && event.getMessageAuthor().isRegularUser()) {
            event.getChannel().sendMessage("hello, yes? testing?");
        }
         */
    }

}
