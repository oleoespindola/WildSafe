package controller;

import java.io.*;
import java.util.*;

import model.EspecieModel;

public class ReadCsvController {
    /*
     * Transforma a lista de espécies em estinção (arquivo csv) em uma lista de
     * objetos EspecieModel
     */

    public Map<String, EspecieModel> readCSV(String csvFile) {

        Map<String, EspecieModel> especies = new HashMap<>();

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(";");

                EspecieModel especie = new EspecieModel();

                especie.setFaunaFlora(data[0]);
                especie.setGrupo(data[1]);
                especie.setFamilia(data[2]);
                especie.setEspecieSimplificado(data[3]);
                especie.setNomeComum(data[4]);
                especie.setCategoriadeAmeaca(data[5]);
                especie.setSiglaCategoriadeAmeaca(data[6]);
                especie.setBioma(data[7]);
                especie.setPrincipaisAmeacas(data[8]);
                especie.setPresencaEmAreasProtegidas(data[9]);
                especie.setPlanodeAcaoNacionalparaConservacaoPAN(data[10]);
                especie.setOrdenamentoPesqueiro(data[11]);
                especie.setNiveldeProtecaoNaEstrategiaNacional(data[12]);
                especie.setEspecieExclusivaDoBrasil(data[13]);
                especie.setEstadosDeOcorrencia(data[14]);

                especies.put(data[4], especie);
            }

            System.out.println(especies.toString());

        } catch (Exception e) {
            System.out.printf("\n\nReadCsvController: Erro ao transformar o CSV em objeto java: %s", e);
        }
        return especies;

    }

}
