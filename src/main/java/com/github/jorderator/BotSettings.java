package com.github.jorderator;

import org.javacord.api.entity.activity.ActivityType;

import java.util.HashMap;
import java.util.Map;

public class BotSettings {
    public static String prefix = ".";

    public static Boolean stinkyToggle;

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



    public static void updateStatus() {
        if (stinkyToggle)
            Main.api.updateActivity((ActivityType) activeActivity.get("type"), (String) activeActivity.get("value"));
        else
            Main.api.updateActivity((ActivityType) inactiveActivity.get("type"), (String) inactiveActivity.get("value"));
    }
}
