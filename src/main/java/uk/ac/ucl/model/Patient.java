package uk.ac.ucl.model;

import java.util.Map;

public class Patient {
    private Map<String, String> fields;

    public Patient(Map<String, String> fields) {
        this.fields = fields;
    }

    public Map<String, String> getFields() {
        return fields;
    }
}
