package com.resume;

import java.util.*;

public class SkillExtractor {

    public static List<String> extractSkills(String text) {

        // Step 1: Normalize text (NLP-style preprocessing)
        text = TextNormalizer.normalizeText(text);

        List<String> skills = new ArrayList<>();

        // Step 2: Skill dictionary (expandable)
        String[] keywords = {
                "java",
                "python",
                "javascript",
                "sql",
                "mysql",
                "git",
                "github",
                "spring boot",
                "rest api",
                "docker",
                "aws",
                "linux",
                "hibernate",
                "microservices"
        };

        // Step 3: Extract matching skills
        for (String keyword : keywords) {

            String normalizedKeyword = keyword.toLowerCase().trim();

            if (text.contains(normalizedKeyword)) {
                skills.add(format(keyword));
            }
        }

        // Step 4: Remove duplicates (important improvement)
        Set<String> uniqueSkills = new LinkedHashSet<>(skills);

        return new ArrayList<>(uniqueSkills);
    }

    // Convert to professional format
    private static String format(String skill) {

        skill = skill.toLowerCase().trim();

        return switch (skill) {

            case "rest api", "restful api" -> "REST API";
            case "spring boot", "springboot" -> "Spring Boot";
            case "mysql" -> "MySQL";
            case "git" -> "Git";
            case "github" -> "GitHub";
            case "sql" -> "SQL";
            case "aws" -> "AWS";
            case "docker" -> "Docker";
            case "javascript" -> "JavaScript";
            case "python" -> "Python";
            case "linux" -> "Linux";
            case "hibernate" -> "Hibernate";
            case "microservices" -> "Microservices";

            default -> {
                String[] words = skill.split(" ");
                StringBuilder sb = new StringBuilder();

                for (String w : words) {
                    if (!w.isEmpty()) {
                        sb.append(Character.toUpperCase(w.charAt(0)))
                                .append(w.substring(1))
                                .append(" ");
                    }
                }

                yield sb.toString().trim();
            }
        };
    }
}