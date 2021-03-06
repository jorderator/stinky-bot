package com.github.jorderator;

import org.javacord.api.entity.activity.ActivityType;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BotSettings {
    public static String prefix = ".";
    public static Color embedColor = new Color(15, 58, 23);

    public static Boolean stinkyToggle;
    public static Boolean messageToggle;

    // TODO: implement this as a list of different statuses. probably change to more general statuses as well
    public static Map<String, Object> activeActivity;
    static {
        activeActivity = new HashMap<>();
        activeActivity.put("type", ActivityType.WATCHING);
        activeActivity.put("value", "for stinkies (toggle with 'toggle stinky')");
    }
    public static Map<String, Object> inactiveActivity;
    static {
        inactiveActivity = new HashMap<>();
        inactiveActivity.put("type", ActivityType.PLAYING);
        inactiveActivity.put("value", "taking a break... (toggle with 'toggle stinky')");
    }

    public static ArrayList<String> suggestions;
    static {
        suggestions = new ArrayList<>();
    }


    public static void updateStatus() {
        if (stinkyToggle)
            Main.api.updateActivity((ActivityType) activeActivity.get("type"), (String) activeActivity.get("value"));
        else
            Main.api.updateActivity((ActivityType) inactiveActivity.get("type"), (String) inactiveActivity.get("value"));
    }
}
