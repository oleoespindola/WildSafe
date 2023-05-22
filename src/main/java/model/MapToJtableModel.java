package model;

import java.util.*;

import javax.swing.table.DefaultTableModel;

public class MapToJtableModel {

    private Map<Integer, EspecieModel> especies = new HashMap<>();

    private DefaultTableModel table = new DefaultTableModel();

    public MapToJtableModel(Map<Integer, EspecieModel> especies) {
        this.especies = especies;
    }

    public DefaultTableModel mapToTable() {

        // Obtem a primeira entrada do mapa para obter os nomes das colunas
        this.table.setColumnIdentifiers(this.especies.get(0).getValuesAsArray());

        // Adiciona as linhas na tabela
        especies.forEach((key, value) -> {
            if(key > 0) {
                this.table.addRow(value.getValuesAsArray());
            }
        });

        return this.table;
    }

}
