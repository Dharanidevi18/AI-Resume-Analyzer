package com.resume;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String text = ResumeParser.extractText("resumes/sample.pdf");

        List<String> resumeSkills = SkillExtractor.extractSkills(text);

        System.out.println("===== RESUME SKILLS =====");
        for (String skill : resumeSkills) {
            System.out.println(skill);
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("\nPaste Job Description:");
        System.out.println("Type END on a new line when finished.");

        StringBuilder jdBuilder = new StringBuilder();

        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("END")) break;
            jdBuilder.append(line).append(" ");
        }

        String jd = jdBuilder.toString();

        List<String> jdSkills = JobDescriptionExtractor.extractSkills(jd);

        System.out.println("\n===== JD SKILLS =====");
        for (String skill : jdSkills) {
            System.out.println(skill);
        }

        // ================= MATCHING =================
        List<String> matchedSkills = JobMatcher.getMatchedSkills(resumeSkills, jdSkills);
        List<String> missingSkills = JobMatcher.getMissingSkills(resumeSkills, jdSkills);

        double matchPercent = JobMatcher.getMatchPercentage(resumeSkills, jdSkills);

        // ================= ATS SCORE =================
        int atsScore = ATSCalculator.calculateScore(resumeSkills, jdSkills);

        // ================= OUTPUT =================
        System.out.println("\n===== MATCH ANALYSIS =====");
        System.out.println("Matched Skills: " + matchedSkills.size() + "/" + jdSkills.size());
        System.out.println("Job Match Percentage: " + matchPercent + "%");

        System.out.println("\n===== MATCHED SKILLS =====");
        for (String s : matchedSkills) {
            System.out.println(s);
        }

        System.out.println("\n===== MISSING SKILLS =====");
        for (String s : missingSkills) {
            System.out.println(s);
        }

        System.out.println("\n===== ATS SCORE =====");
        System.out.println("ATS Score: " + atsScore + "/100");

        RecommendationEngine.suggest(missingSkills);
        ResumeSuggestion.analyze(text);

        sc.close();
    }
}