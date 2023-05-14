package controllers;

import java.io.IOException;

import java.net.URISyntaxException;
import java.net.URI;
import java.net.URL;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.EspecieModel;

public class EspeciesControllers {
    
    private URL url;

    private EspecieModel especie;

    public void setEspecie(EspecieModel especie) {
        this.especie = especie;
    }

    public EspecieModel getEspecie() {
        return especie;
    }

    public EspeciesControllers(String dblink) throws URISyntaxException, IOException {
        URI uri = new URI(dblink);
        url = uri.toURL();
        evocarDB();
    }

    
    public void evocarDB() throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            setEspecie(objectMapper.readValue(url, EspecieModel.class));;
            System.out.print(especie);
        } catch (JacksonException e) {
            System.out.println("Erro");
        }

    }
    
}
