package uk.ac.ucl.model;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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

    // This also returns dummy data. The real version should use the keyword parameter to search
    // the data and return a list of matching items.
    public List<String> searchFor(String keyword) {
        return List.of("Search keyword is: " + keyword, "result1", "result2", "result3");
    }
}
