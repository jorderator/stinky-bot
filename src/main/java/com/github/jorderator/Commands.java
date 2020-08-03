package com.github.jorderator;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Commands {

    // TODO: check this, because it isn't reaching .suggest
    private static Pattern suggestPattern;
    static {
        suggestPattern = Pattern.compile("$\\" + BotSettings.prefix + "suggest (.+)^");
    }

    public static Boolean processCommands(String content, MessageCreateEvent event) {
        if (content.equals(BotSettings.prefix + "help")) {
            EmbedBuilder helpEmbed = new EmbedBuilder()
                    .setTitle("Stinky-bot help:")
                    .setColor(BotSettings.embedColor)
                    .setDescription("Command list for stinky-bot.")
                    .addField("Commands:", "---------------")
                    .addField(".help", "displays this page")
                    .addInlineField(".toggle stinky", "toggle whether to respond to certain user messages")
                    .addInlineField(".invite", "get the bot invite link, to invite it to a server")
                    .addInlineField(".suggestions", "list bot feature suggestions")
                    .addInlineField(".suggest", "submit a feature suggestion for the bot")
                    .setFooter("stinky-bot", event.getApi().getYourself().getAvatar());

            event.getChannel().sendMessage(helpEmbed);
            return true;
        }

        if (content.equals(BotSettings.prefix + "toggle stinky")) {
            BotSettings.stinkyToggle = !BotSettings.stinkyToggle;
            event.getChannel().sendMessage("stinky-detecting toggled to " + (BotSettings.stinkyToggle? "on": "off"));

            BotSettings.updateStatus();

            return true;
        }

        if (content.equals(BotSettings.prefix + "invite")) {
            event.getChannel().sendMessage("Invite me to a server with: " + Main.api.createBotInvite());

            return true;
        }

        if (content.equals(BotSettings.prefix + "suggestions")) {
            System.out.println("Made it to .suggestions");
            String suggestionsString = "";
            for (String suggestion : BotSettings.suggestions) {
                suggestionsString = suggestionsString + "\n - " + suggestion;
            }

            EmbedBuilder suggestionsEmbed = new EmbedBuilder()
                    .setTitle("Suggestions list:")
                    .setColor(BotSettings.embedColor)
                    .setFooter("stinky-bot", event.getApi().getYourself().getAvatar())
                    .setDescription("List of suggested bot features/ideas.")
                    .addField("Suggestions:", suggestionsString);

            event.getChannel().sendMessage(suggestionsEmbed);

            return true;
        }

        Matcher m = suggestPattern.matcher(content);
        if (m.find()) {
            System.out.println("Made it to .suggest");
            String value = m.group(1);
            BotSettings.suggestions.add(value);
            event.getChannel().sendMessage('"' + value + "\" added to suggestions.");

            return true;
        }

        return false;
    }

    public static void initialiseBot() {

    }

}
