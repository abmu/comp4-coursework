package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DataFrame {
    private Map<String, Column> columns = new LinkedHashMap<>();

    public void addColumn(String columnName) {
        columns.put(columnName, new Column(columnName));
    }

    public List<String> getColumnNames() {
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

    public List<String> getColumnRows(String columnName) {
        return columns.get(columnName).getRows();
    }

    public List<Integer> findIndexes(String columnName, String value) {
        return columns.get(columnName).findRowIndexes(value);
    }

    public Map<String, String> getRowColumns(int rowIndex) {
        Map<String, String> rowColumns = new LinkedHashMap<>();
        Set<String> columnNames = columns.keySet();
        for (String columnName : columnNames) {
            rowColumns.put(columnName, columns.get(columnName).getRowValue(rowIndex));
        }
        return rowColumns;
    }

    public List<String> getRow(int rowIndex) {
        List<String> row = new ArrayList<>();
        Set<String> columnNames = columns.keySet();
        for (String columnName : columnNames) {
            row.add(columns.get(columnName).getRowValue(rowIndex));
        }
        return row;
    }

    public void putRow(int rowIndex, List<String> row) {
        List<String> columnNames = getColumnNames();
        for (int i = 0; i < columnNames.size(); i++) {
            String columnName = columnNames.get(i);
            String rowValue = row.get(i);
            columns.get(columnName).setRowValue(rowIndex, rowValue);
        }
    }

    public void addRow(List<String> row) {
        List<String> columnNames = getColumnNames();
        for (int i = 0; i < columnNames.size(); i++) {
            String columnName = columnNames.get(i);
            String rowValue = row.get(i);
            columns.get(columnName).addRowValue(rowValue);
        }
    }

    public void deleteRow(int rowIndex) {
        Set<String> columnNames = columns.keySet();
        for (String columnName : columnNames) {
            columns.get(columnName).deleteRowValue(rowIndex);
        }
    }
}
