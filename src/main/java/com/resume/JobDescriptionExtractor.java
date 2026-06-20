package com.resume;

import java.util.ArrayList;
import java.util.List;

public class JobDescriptionExtractor {

    static String[] skills = {
            "Java",
            "Python",
            "JavaScript",
            "SQL",
            "MySQL",
            "Git",
            "GitHub",
            "Linux",
            "CCNA",
            "Wireshark",
            "HTML",
            "CSS",
            "React",
            "Spring Boot",
            "REST API",
            "Docker",
            "AWS",
            "Microservices",
            "Hibernate",
            "MongoDB",
            "Node.js",
            "Angular"
    };

    public static List<String> extractSkills(String jd) {

        List<String> foundSkills = new ArrayList<>();

        for (String skill : skills) {

            if (jd.toLowerCase().contains(skill.toLowerCase())) {

                foundSkills.add(skill);
            }
        }

        return foundSkills;
    }
}