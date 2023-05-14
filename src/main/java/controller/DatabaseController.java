package controller;

import java.io.IOException;

import java.net.*;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.EspecieModel;  

public class DatabaseController {
    
    private URL url;

    private EspecieModel especie;

    public void setEspecie(EspecieModel especie) {
        this.especie = especie;
    }

    public EspecieModel getEspecie() {
        return especie;
    }

    public DatabaseController(String dblink) throws URISyntaxException, IOException {
        URI uri = new URI(dblink);
        url = uri.toURL();
        evocarDB();
    }

    
    public void evocarDB() throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            setEspecie(objectMapper.readValue(url, EspecieModel.class));
        } catch (JacksonException e) {
            System.out.println("Erro");
        }

    }
    
}
