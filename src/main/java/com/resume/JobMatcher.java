package com.resume;

import java.util.ArrayList;
import java.util.List;

public class JobMatcher {

    // MATCHED SKILLS
    public static List<String> getMatchedSkills(List<String> resumeSkills, List<String> jdSkills) {

        List<String> matched = new ArrayList<>();

        for (String skill : resumeSkills) {
            if (jdSkills.contains(skill)) {
                matched.add(skill);
            }
        }

        return matched;
    }

    // MISSING SKILLS
    public static List<String> getMissingSkills(List<String> resumeSkills, List<String> jdSkills) {

        List<String> missing = new ArrayList<>();

        for (String skill : jdSkills) {
            if (!resumeSkills.contains(skill)) {
                missing.add(skill);
            }
        }

        return missing;
    }

    // MATCH PERCENTAGE
    public static double getMatchPercentage(List<String> resumeSkills, List<String> jdSkills) {

        if (jdSkills == null || jdSkills.isEmpty()) {
            return 0;
        }

        int matchedCount = getMatchedSkills(resumeSkills, jdSkills).size();

        return ((double) matchedCount / jdSkills.size()) * 100;
    }
}