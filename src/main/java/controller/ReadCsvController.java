package controller;

import java.io.*;
import java.util.*;

import model.EspecieModel;

public class ReadCsvController {
    /*
     * Transforma a lista de espécies em estinção (arquivo csv) em uma lista de objetos java
     */

    public ReadCsvController(String csvFile) {
        readCSV(csvFile);
    }

    public ArrayList<EspecieModel> readCSV(String csvFile) {

        ArrayList<EspecieModel> especies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String  line;
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                 EspecieModel especieModel = new EspecieModel();

                 especieModel.setFaunaFlora(data[0]);
                 especieModel.setGrupo(data[1]);
                 especieModel.setFamilia(data[2]);
                 especieModel.setEspecieSimplificado(data[3]);
                 especieModel.setNomeComum(data[4]);
                 especieModel.setCategoriadeAmeaca(data[5]);
                 especieModel.setSiglaCategoriadeAmeaca(data[6]);
                 especieModel.setBioma(data[7]);
                 especieModel.setPrincipaisAmeacas(data[8]);
                 especieModel.setPresencaEmAreasProtegidas(data[9]);
                 especieModel.setPlanodeAcaoNacionalparaConservacaoPAN(data[10]);
                 especieModel.setOrdenamentoPesqueiro(data[11]);
                 especieModel.setNiveldeProtecaoNaEstrategiaNacional(data[12]);
                 especieModel.setEspecieExclusivaDoBrasil(data[13]);
                 especieModel.setEstadosDeOcorrencia(data[15]);

                 especies.add(especieModel);

                 return especies;
            }   
            
        } catch (Exception e) {
            return null;
        }
        return null;
    }
    
}
