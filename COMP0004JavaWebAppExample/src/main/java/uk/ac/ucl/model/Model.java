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
    // The example code in this class should be replaced by your Model class code.
    // The data should be stored in a suitable data structure.
    DataLoader dataLoader = new DataLoader();
    DataFrame dataFrame = new DataFrame();

    public List<String> getPatientNames() {
        return readFile("data/patients100.csv");
    }

    // This method illustrates how to read csv data from a file.
    // The data files are stored in the root directory of the project (the directory your project is in),
    // in the directory named data.
    public List<String> readFile(String fileName) {
        if (!dataLoader.loadFile(fileName)) {
            return new ArrayList<>();
        }
        dataFrame = dataLoader.getDataFrame();
        return dataFrame.getColumnRows("ID");
    }

    // This also returns dummy data. The real version should use the keyword parameter to search
    // the data and return a list of matching items.
    public List<String> searchFor(String keyword) {
        return List.of("Search keyword is: " + keyword, "result1", "result2", "result3");
    }
}
