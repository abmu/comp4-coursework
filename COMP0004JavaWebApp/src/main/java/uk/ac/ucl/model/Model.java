package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model {
    DataLoader dataLoader = new DataLoader();
    DataWriter dataWriter = new DataWriter();
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

    public List<String> getPatientIds() {
        return dataFrame.getColumnRows("ID");
    }

    public Map<String, String> getPatientRecord(String patientId) {
        int rowIndex = dataFrame.findIndexes("ID", patientId).getFirst();
        return dataFrame.getRowColumns(rowIndex);
    }

    public List<Map<String, String>> searchFor(String columnName, String searchString) {
        List<Integer> rowIndexes = dataFrame.findIndexes(columnName, searchString);
        List<Map<String, String>> results = new ArrayList<>();
        for (int rowIndex : rowIndexes) {
            results.add(dataFrame.getRowColumns(rowIndex));
        }
        return results;
    }

    public void updatePatientRecord(String patientId, List<String> rowValues) {
        int rowIndex = dataFrame.findIndexes("ID", patientId).getFirst();
        dataFrame.putRow(rowIndex, rowValues);
    }
}
