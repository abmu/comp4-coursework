package uk.ac.ucl.model;

import java.util.ArrayList;

public class DataFrame {
    private ArrayList<Column> columns = new ArrayList<>();

    public void addColumn(Column column) {
        columns.add(column);
    }

    public ArrayList<String> getColumnNames() {
        ArrayList<String> columnNames = new ArrayList<>(columns.size());
        for (Column column : columns) {
            columnNames.add(column.getName());
        }
        return columnNames;
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
