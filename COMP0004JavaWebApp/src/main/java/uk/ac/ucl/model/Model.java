package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model {
    DataLoader dataLoader = new DataLoader();
    DataFrame dataFrame = new DataFrame();

    public void readFile(String fileName) {
        if (!dataLoader.loadFile(fileName)) {
            dataFrame = new DataFrame();
        }
        dataFrame = dataLoader.getDataFrame();
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
}
