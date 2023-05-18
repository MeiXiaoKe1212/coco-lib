package com.coco.agent;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.List;

/**
 * UserAgent
 *
 * @author coco
 * @date 2023-05-17
 */
public class UserAgent {
    private static List<String> userAgentsWindows = null;

    static {
        URL url = Resources.getResource("userAgents_windows");
        if (url != null) {
            File file = new File(url.getPath());
            try {
                userAgentsWindows = Files.readLines(file, Charsets.UTF_8);
            } catch (Exception ex) {
            }
        }
    }

    public static String getUserAgentWindows() {
        if (userAgentsWindows == null || userAgentsWindows.size() == 0) {
            return "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
        }
        Collections.shuffle(userAgentsWindows);
        return userAgentsWindows.get(0);
    }

}
