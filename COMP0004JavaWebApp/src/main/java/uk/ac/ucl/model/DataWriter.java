package uk.ac.ucl.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class DataWriter {
    public boolean writeFile(String fileName, DataFrame dataFrame) {
        boolean success = false;
        try (Writer writer = new FileWriter(fileName);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            List<String> columnNames = dataFrame.getColumnNames();
            csvPrinter.printRecord(columnNames);
            int rowCount = dataFrame.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                csvPrinter.printRecord(dataFrame.getRow(i));
            }
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }
}
