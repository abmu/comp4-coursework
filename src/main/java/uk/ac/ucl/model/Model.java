package uk.ac.ucl.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model {
    private DataLoader dataLoader = new DataLoader();
    private DataWriter dataWriter = new DataWriter();
    private JSONWriter jsonWriter = new JSONWriter();
    private DataFrame dataFrame = new DataFrame();
    private String dataFileName;
    private String jsonFileName;

    public Model(String dataFileName) {
        this.dataFileName = dataFileName;
        this.jsonFileName = "src/main/webapp/" + getJsonName(dataFileName);
    }

    private String getJsonName(String fileName) {
        // remove current path and change file extension from .csv to .json (not guaranteed to work depending on original file path)
        String namePart = Paths.get(fileName).getFileName().toString();
        return namePart.substring(0, namePart.lastIndexOf('.')) + ".json";
    }

    public String getJsonName() {
        return getJsonName(dataFileName);
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

    public Map<String, String> getPatientRecord(String patientId) {
        int rowIndex = dataFrame.findIndexExact("ID", patientId);
        return dataFrame.getRowColumns(rowIndex);
    }

    public List<Map<String, String>> searchFor(String columnName, String searchString) {
        List<Integer> rowIndexes = dataFrame.findIndexesContain(columnName, searchString);
        List<Map<String, String>> results = new ArrayList<>();
        for (int rowIndex : rowIndexes) {
            results.add(dataFrame.getRowColumns(rowIndex));
        }
        return results;
    }

    public void updatePatientRecord(String patientId, List<String> rowValues) {
        int rowIndex = dataFrame.findIndexExact("ID", patientId);
        dataFrame.putRow(rowIndex, rowValues);
    }

    public List<String> getColumnNames() {
        return dataFrame.getColumnNames();
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
}
