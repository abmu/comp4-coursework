package uk.ac.ucl.model;

import java.util.ArrayList;

public class DataFrame {
    private ArrayList<Column> columns = new ArrayList<>();
    private ArrayList<String> columnNames = new ArrayList<>();

    public void addColumn(String columnName) {
        columns.add(new Column(columnName));
        columnNames.add(columnName);
    }

    public ArrayList<String> getColumnNames() {
        return new ArrayList<>(columnNames);
    }

    public int getRowCount() {
        // All columns should have the same number of rows
        return columns.getFirst().getSize();
    }

    public String getValue(String columnName, int row) {
        for (Column column: columns) {
            if (column.getName().equals(columnName)) {
                return column.getRowValue(row);
            }
        }
        return "";
    }

    public boolean putValue(String columnName, int row, String value) {
        for (Column column: columns) {
            if (column.getName().equals(columnName)) {
                column.setRowValue(row, value);
                return true;
            }
        }
        return false;
    }

    public boolean addValue(String columnName, String value) {
        for (Column column: columns) {
            if (column.getName().equals(columnName)) {
                column.addRowValue(value);
                return true;
            }
        }
        return false;
    }
}
