package uk.ac.ucl.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONWriter implements DataWriter {
    private List<Map<String, String>> getListRowColumns(DataFrame dataFrame) {
        List<Map<String, String>> listRowColumns = new ArrayList<>();
        int rowCount = dataFrame.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            listRowColumns.add(dataFrame.getRowColumns(i));
        }
        return listRowColumns;
    }

    public boolean writeFile(String fileName, DataFrame dataFrame) {
        boolean success = false;
        ObjectMapper mapper = new ObjectMapper();
        try (Writer writer = new FileWriter(fileName)) {
            List<Map<String, String>> listRowColumns = getListRowColumns(dataFrame);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listRowColumns);
            writer.write(jsonString);
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }
}
