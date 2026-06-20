package com.resume;

import java.util.*;

public class TextNormalizer {

    private static final Map<String, String> synonyms = new HashMap<>();

    static {
        synonyms.put("springboot", "spring boot");
        synonyms.put("spring-boot", "spring boot");
        synonyms.put("restful api", "rest api");
        synonyms.put("restful services", "rest api");
        synonyms.put("git hub", "github");
        synonyms.put("mysql database", "mysql");
    }

    public static String normalizeText(String text) {

        if (text == null) return "";

        // 1. lowercase
        text = text.toLowerCase();

        // 2. remove special characters
        text = text.replaceAll("[^a-z0-9 ]", " ");

        // 3. normalize spaces
        text = text.replaceAll("\\s+", " ").trim();

        // 4. replace synonyms
        for (Map.Entry<String, String> entry : synonyms.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }

        return text;
    }
}