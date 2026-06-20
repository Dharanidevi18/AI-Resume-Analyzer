package com.resume;

import java.util.List;

public class ATSCalculator {

    public static int calculateScore(List<String> resumeSkills, List<String> jdSkills) {

        if (jdSkills == null || jdSkills.isEmpty()) {
            return 0;
        }

        int matched = 0;

        for (String jdSkill : jdSkills) {
            if (resumeSkills.contains(jdSkill)) {
                matched++;
            }
        }

        double score = ((double) matched / jdSkills.size()) * 100;

        return (int) score;
    }
}