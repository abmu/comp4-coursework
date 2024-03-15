package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model {
    DataLoader dataLoader = new DataLoader();
    DataWriter dataWriter = new DataWriter();
    JSONWriter jsonWriter = new JSONWriter();
    DataFrame dataFrame = new DataFrame();
    String dataFileName;

    public Model(String dataFileName) {
        this.dataFileName = dataFileName;
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
        String jsonFileName = dataFileName.substring(0, dataFileName.lastIndexOf('.')) + ".json"; // Change file extension from .csv to .json, but not guaranteed to work depending on file path
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
