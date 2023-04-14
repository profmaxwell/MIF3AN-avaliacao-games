package com.mobile.pacifier.config;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryConfig {

    private static Map<String, String> config;

    public static Map<String, String> getMyConfig() {
        if (config == null) {
            config = new HashMap<>();
            config.put("cloud_name", "da1uhb7h7");
            config.put("api_key", "735712753112324");
            config.put("api_secret", "5Mi0SwUMDWqOGV2ky3J2azmYN5c");
        }
        return config;
    }

}
