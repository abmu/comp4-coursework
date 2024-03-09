package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataFrame {
    private Map<String, Column> columns = new HashMap();

    public void addColumn(String columnName) {
        columns.put(columnName, new Column(columnName));
    }

    public ArrayList<String> getColumnNames() {
        return new ArrayList<>(columns.keySet());
    }

    public int getRowCount() {
        if (columns.isEmpty()) {
            return -1;
        }
        // All columns should have the same number of rows
        String randomKey = columns.keySet().iterator().next();
        return columns.get(randomKey).getSize();
    }

    public String getValue(String columnName, int row) {
        return columns.get(columnName).getRowValue(row);
    }

    public void putValue(String columnName, int row, String value) {
        columns.get(columnName).setRowValue(row, value);
    }

    public void addValue(String columnName, String value) {
        columns.get(columnName).addRowValue(value);
    }
}
