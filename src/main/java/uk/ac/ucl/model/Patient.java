package uk.ac.ucl.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Patient {
    private Map<String, String> fields;

    public Patient(Map<String, String> fields) {
        this.fields = fields;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public String getField(String field) {
        return fields.get(field).replaceAll("\\s","");
    }

    private LocalDate parseDate(String dateString) {
        dateString = dateString.replaceAll("\\p{Punct}", "");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        try {
            return LocalDate.parse(dateString, dateTimeFormatter);
        } catch (DateTimeException e) {
            return LocalDate.now();
        }
    }

    public int getAge() {
        LocalDate birthDate = parseDate(getField("BIRTHDATE"));
        LocalDate deathDate = parseDate(getField("DEATHDATE")); // returns current date if death date is empty
        return Period.between(birthDate, deathDate).getYears();
    }

    public String getName() {
        return getField("FIRST") + " " + getField("LAST");
    }

    public int getNameLength() {
        return getName().replaceAll("\\s","").length();
    }

    private String toTitleCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public String getCity() {
        return toTitleCase(getField("CITY")) + ", " + toTitleCase(getField("STATE"));
    }

    public String getGender() {
        String gender = getField("GENDER").toLowerCase();
        if (gender.equals("male") || gender.equals("m")) {
            return "Male";
        } else if (gender.equals("female") || gender.equals("f")) {
            return "Female";
        } else {
            return "Other";
        }
    }

    public String getEthnicity() {
        return toTitleCase(getField("ETHNICITY"));
    }

    public String getAgeRange() {
        int age = getAge();
        int lowerBound = (age / 10) * 10;
        int upperBound = lowerBound + 9;
        return lowerBound + "-" + upperBound;
    }

    public String toString() {
        return fields.toString();
    }
}
