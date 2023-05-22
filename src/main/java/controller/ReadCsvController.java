package controller;

import java.io.*;
import java.util.*;

import model.EspecieModel;

public class ReadCsvController {
    /*
     * Transforma a lista de espécies em estinção (arquivo csv) em uma lista de
     * objetos EspecieModel
     */

    public Map<Integer, EspecieModel> readCSV(String csvFile) {

        Map<Integer, EspecieModel> especies = new HashMap<>();
        String line;
        int key = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {

                String[] column = line.split(";");

                EspecieModel especie = new EspecieModel();

                especie.setFaunaFlora(column[0]);
                especie.setGrupo(column[1]);
                especie.setFamilia(column[2]);
                especie.setEspecieSimplificado(column[3]);
                especie.setNomeComum(column[4]);
                especie.setCategoriadeAmeaca(column[5]);
                especie.setSiglaCategoriadeAmeaca(column[6]);
                especie.setBioma(column[7]);
                especie.setPrincipaisAmeacas(column[8]);
                especie.setPresencaEmAreasProtegidas(column[9]);
                especie.setPlanodeAcaoNacionalparaConservacaoPAN(column[10]);
                especie.setOrdenamentoPesqueiro(column[11]);
                especie.setNiveldeProtecaoNaEstrategiaNacional(column[12]);
                especie.setEspecieExclusivaDoBrasil(column[13]);
                especie.setEstadosDeOcorrencia(column[14]);

                especies.put(key, especie);
                key++;
            }

        } catch (Exception e) {
            System.out.printf("\n\nReadCsvController: Erro ao transformar o CSV em objeto java: %s", e);
        }
        return especies;

    }

}