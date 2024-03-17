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
        return fields.get(field);
    }

    private LocalDate parseDate(String dateString) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(dateString, dateTimeFormatter);
        } catch (DateTimeException e) {
            return LocalDate.now();
        }
    }

    public int getAge() {
        LocalDate birthDate = parseDate(fields.get("BIRTHDATE"));
        LocalDate deathDate = parseDate(fields.get("DEATHDATE")); // returns current date if death date is empty
        return Period.between(birthDate, deathDate).getYears();
    }

    public String getName() {
        return fields.get("FIRST") + " " + fields.get("LAST");
    }

    public int getNameLength() {
        return getName().replaceAll("\\s","").length();
    }

    public String getCity() {
        return fields.get("CITY") + ", " + fields.get("STATE");
    }

    public String toString() {
        return fields.toString();
    }
}
