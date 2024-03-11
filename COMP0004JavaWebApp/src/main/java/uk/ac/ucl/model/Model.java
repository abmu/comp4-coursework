package uk.ac.ucl.model;

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
        int rowIndex = dataFrame.findIndex("ID", patientId);
        return dataFrame.getRowColumns(rowIndex);
    }

    // This also returns dummy data. The real version should use the keyword parameter to search
    // the data and return a list of matching items.
    public List<String> searchFor(String keyword) {
        return List.of("Search keyword is: " + keyword, "result1", "result2", "result3");
    }
}
