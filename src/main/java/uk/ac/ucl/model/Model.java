package uk.ac.ucl.model;

import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Model {
    private DataLoader dataLoader = new DataLoader();
    private DataWriter dataWriter = new DataWriter();
    private JSONWriter jsonWriter = new JSONWriter();
    private DataFrame dataFrame = new DataFrame();
    private String dataFileName;
    private String jsonFileName;

    public Model(String dataFileName) {
        this.dataFileName = dataFileName;
        this.jsonFileName = "src/main/webapp/" + getJsonFileName(dataFileName);
    }

    private String getJsonFileName(String fileName) {
        // remove current path and change file extension from .csv to .json (not guaranteed to work depending on original file path)
        String namePart = Paths.get(fileName).getFileName().toString();
        return "data/" + namePart.substring(0, namePart.lastIndexOf('.')) + ".json";
    }

    public String getJsonFileName() {
        return getJsonFileName(dataFileName);
    }

    public void readFile(String fileName) {
        if (!dataLoader.loadFile(fileName)) {
            dataFrame = new DataFrame();
            return;
        }
        dataFrame = dataLoader.getDataFrame();
    }

    public void readFile() {
        readFile(dataFileName);
    }

    public void writeFile(String fileName) {
        dataWriter.writeFile(fileName, dataFrame);
    }

    public void writeFile() {
        writeFile(dataFileName);
    }

    public void writeJsonFile(String fileName) {
        jsonWriter.writeFile(fileName, dataFrame);
    }

    public void writeJsonFile() {
        writeJsonFile(jsonFileName);
    }

    public List<String> getPatientIds() {
        return dataFrame.getColumnRows("ID");
    }

    public List<String> getColumnNames() {
        return dataFrame.getColumnNames();
    }

    public List<Patient> searchFor(String columnName, String searchString) {
        List<Integer> rowIndexes = dataFrame.findIndexesContain(columnName, searchString);
        List<Patient> results = new ArrayList<>();
        for (int rowIndex : rowIndexes) {
            results.add(new Patient(dataFrame.getRowColumns(rowIndex)));
        }
        return results;
    }

    public Patient getPatientRecord(String patientId) {
        int rowIndex = dataFrame.findIndexExact("ID", patientId);
        return new Patient(dataFrame.getRowColumns(rowIndex));
    }

    public void updatePatientRecord(String patientId, List<String> rowValues) {
        int rowIndex = dataFrame.findIndexExact("ID", patientId);
        dataFrame.putRow(rowIndex, rowValues);
    }

    public void addPatientRecord(List<String> rowValues) {
        String patientId = rowValues.getFirst();
        if (!dataFrame.hasValue("ID", patientId)) {
            dataFrame.addRow(rowValues);
        }
    }

    public void deletePatientRecord(String patientId) {
        int rowIndex = dataFrame.findIndexExact("ID", patientId);
        dataFrame.deleteRow(rowIndex);
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        List<Map<String, String>> allRowColumns = dataFrame.getAllRowColumns();
        for (Map<String, String> rowColumn : allRowColumns) {
            patients.add(new Patient(rowColumn));
        }
        return patients;
    }

    public Patient getOldestPatient() {
        return getAllPatients().stream()
                .max(Comparator.comparing(Patient::getAge))
                .orElse(null);
    }

    public Patient getYoungestPatient() {
        return getAllPatients().stream()
                .min(Comparator.comparing(Patient::getAge))
                .orElse(null);
    }

    public Patient getLongestNamePatient() {
        return getAllPatients().stream()
                .max(Comparator.comparing(Patient::getNameLength))
                .orElse(null);
    }

    public Map.Entry<String, List<Patient>> getMostCommonCity() {
        return getAllPatients().stream()
                .collect(Collectors.groupingBy(Patient::getCity, Collectors.toList()))
                .entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue().size()))
                .orElse(null);
    }

    public Map<String, Integer> getAgeDistribution() {
        Map<String, Integer> ageDistribution = new LinkedHashMap<>() {{
            put("\"0-9\"", 0);
            put("\"10-19\"", 0);
            put("\"20-29\"", 0);
            put("\"30-39\"", 0);
            put("\"40-49\"", 0);
            put("\"50-59\"", 0);
            put("\"60-69\"", 0);
            put("\"70-79\"", 0);
            put("\"80-89\"", 0);
            put("\"90-99\"", 0);
        }};
        List<Patient> patients = getAllPatients();
        for (Patient patient : patients) {
            String ageRange = '"' + patient.getAgeRange() + '"'; // Add quotation marks to make the key set string a valid JavaScript array
            if (!ageDistribution.containsKey(ageRange)) {
                ageDistribution.put(ageRange, 0);
            }
            ageDistribution.put(ageRange, ageDistribution.get(ageRange) + 1);
        }
        return ageDistribution;
    }

    public Map<String, Long> getGenderCount() {
        return getAllPatients().stream()
                .collect(Collectors.groupingBy(
                        patient -> '"' + patient.getGender() + '"',
                        Collectors.counting()
                ));
    }

    public Map<String, Long> getEthnicityCount() {
        return getAllPatients().stream()
                .collect(Collectors.groupingBy(
                        patient -> '"' + patient.getEthnicity() + '"',
                        Collectors.counting()
                ));
    }
}
