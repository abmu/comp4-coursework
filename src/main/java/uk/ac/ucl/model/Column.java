package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class Column {
    private String name;
    private List<String> rows = new ArrayList<>();

    public Column(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return rows.size();
    }

    public String getRowValue(int rowIndex) {
        return rows.get(rowIndex);
    }

    public void setRowValue(int rowIndex, String value) {
        rows.set(rowIndex, value);
    }

    public void addRowValue(String value) {
        rows.add(value);
    }

    public boolean hasRowValue(String value) {
        return rows.contains(value);
    }

    public List<String> getRows() {
        return new ArrayList<>(rows);
    }

    public List<Integer> findIndexesContain(String value) {
        String lowerCaseValue = value.toLowerCase();
        List<Integer> rowIndexes = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).toLowerCase().contains(lowerCaseValue)) {
                rowIndexes.add(i);
            }
        }
        return rowIndexes;
    }

    public int findIndexExact(String value) {
        return rows.indexOf(value);
    }

    public void deleteRowValue(int rowIndex) {
        rows.remove(rowIndex);
    }
}
