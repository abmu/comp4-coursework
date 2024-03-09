package uk.ac.ucl.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    private DataFrame dataFrame = new DataFrame();

    private void loadHeaders(CSVRecord csvHeaders) {
        for (String columnName : csvHeaders) {
            dataFrame.addColumn(columnName);
        }
    }

    private void loadRecord(ArrayList<String> columnNames, CSVRecord csvRecord) {
        for (int i = 0; i < columnNames.size(); i++) {
            dataFrame.addValue(columnNames.get(i), csvRecord.get(i));
        }
    }

    private void loadRecords(List<CSVRecord> csvRecords) {
        loadHeaders(csvRecords.getFirst()); // First record contains column headers
        ArrayList<String> columnNames = dataFrame.getColumnNames();
        for (int i = 1; i < csvRecords.size(); i++) { // Skip zero index
            loadRecord(columnNames, csvRecords.get(i));
        }
    }

    public boolean loadFile(String fileName) {
        dataFrame = new DataFrame();
        boolean success = false;
        try (Reader reader = new FileReader(fileName);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            List<CSVRecord> csvRecords = csvParser.getRecords();
            loadRecords(csvRecords);
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }

    public DataFrame getDataFrame() {
        return dataFrame;
    }
}
