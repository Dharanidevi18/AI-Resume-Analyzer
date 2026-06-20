package com.resume;

import java.util.List;

public class RecommendationEngine {

    public static void suggest(List<String> missingSkills) {

        System.out.println("\n===== RECOMMENDATIONS =====");

        for(String skill : missingSkills) {

            switch(skill) {

                case "Spring Boot":
                    System.out.println(
                            "Learn Spring Boot and build a CRUD project.");
                    break;

                case "REST API":
                    System.out.println(
                            "Create REST APIs using Spring Boot.");
                    break;

                case "React":
                    System.out.println(
                            "Build a React frontend project.");
                    break;

                default:
                    System.out.println(
                            "Add " + skill + " to your skill set.");
            }
        }
    }
}