package com.resume;

public class ResumeSuggestion {

    public static void analyze(String text) {

        System.out.println("\n===== RESUME SUGGESTIONS =====");

        if (!text.toLowerCase().contains("experience")) {
            System.out.println("Add an Experience section.");
        }

        if (!text.toLowerCase().contains("certification")) {
            System.out.println("Add Certifications section.");
        }

        if (!text.toLowerCase().contains("achievement")) {
            System.out.println("Add Achievements section.");
        }
    }
}