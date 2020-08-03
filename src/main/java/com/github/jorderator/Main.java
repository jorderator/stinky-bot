package com.github.jorderator;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.DiscordEntity;
import org.javacord.api.entity.Nameable;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static DiscordApi api;

    // TODO: implement persistent configuration
    // TODO: add support for prefix changing

    public static void messageCreateHandling(MessageCreateEvent event) {
        // TODO: add proper commands (including administration etc?)
        // Commands:
        if (Commands.processCommands(event.getMessageContent(), event))
            return;

        // User responses:
        if (BotSettings.stinkyToggle) {
            Responses.respondToUser(event.getMessageAuthor().getId(), event);
        }

        //Responses.respondToMessage(event);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BotSettings.stinkyToggle = false;

        // Get discord api token from a 'token.txt' file, in current working path
        // TODO: Implement token system better
        String token = "";
        try {
            File tokenFile = new File("token.txt");
            Scanner fileReader = new Scanner(tokenFile);
            token = fileReader.nextLine();
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Token file not found, please place discord bot token into a token.txt file next to the executable.");
            e.printStackTrace();
            System.exit(1);
        }
        if (token.equals("")) {
            System.out.println("Token not found in token.txt, please place the bot token in token.txt");
            System.exit(1);
        }

        api = new DiscordApiBuilder().setToken(token).login().join();

        BotSettings.updateStatus();

        api.addMessageCreateListener(Main::messageCreateHandling);

        System.out.println("Invite bot with this url: " + api.createBotInvite());

        // Exiting the bot
        while (true) {
            System.out.print("\n enter 'stop' to close the bot: ");
            if (in.nextLine().equals("stop")) {
                System.exit(0);
            }
        }
    }

}
