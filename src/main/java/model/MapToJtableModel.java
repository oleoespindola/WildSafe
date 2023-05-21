package model;

import java.util.*;

import javax.swing.table.DefaultTableModel;

public class MapToJtableModel {
    
    private Map<String, EspecieModel> especies = new HashMap<>();

    private DefaultTableModel table = new DefaultTableModel();

    public MapToJtableModel(Map<String, EspecieModel> especies) {
        this.especies = especies;
    }

    public DefaultTableModel mapToTable() {
        this.especies.forEach((key, value) -> {
            this.table.addColumn(key);
        });
        return this.table;
    }

}
