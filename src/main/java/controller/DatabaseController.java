package controller;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.EspecieModel;

public class DatabaseController {
    /*
     * Lê, grava, altera e deleta os registros no banco de dados do projeto
     */

    private String url = "https://wildsafeapp-default-rtdb.firebaseio.com/"; // URL do banco

    private ObjectMapper objectMapper = new ObjectMapper();
    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private Map<Integer, EspecieModel> especies = new HashMap<>();
    HttpResponse response;

    public DatabaseController() {
        
    }

    public void setDatabase() {
        String csv = "csv/lista-de-especies-ameacas-2020.csv";

        ReadCsvController readCSV = new ReadCsvController(); // Instacia classe de leitura de csv

        // Transforma o arquivo csv em objeto
        this.especies.putAll(readCSV.readCSV(csv));
        /*
         * Grava o arquivo csv no banco de dados
         */

        try {

            String applicationJson = this.objectMapper.writeValueAsString(this.especies);

            HttpPut request = new HttpPut(url + "/.json"); // Instancia a rquisição
            request.setHeader("Content-Type", "application/json");

            // Declara a entidade HTTP
            HttpEntity entity = new StringEntity(applicationJson, ContentType.APPLICATION_JSON);
            request.setEntity(entity);

            // Executar a requisição
            this.response = httpClient.execute(request);

            // verificar o status da rquisição
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                System.out.printf("\n\nDatabaseController | Requisição executada com suscesso: %s", statusCode);
            } else {
                System.out.printf("\n\nDatabaseController | Falha ao atualizar o recurso. Código de resposta: %s",
                        statusCode);
            }

        } catch (JsonProcessingException e) {
            System.out.printf("\n\nDatabaseController | Erro no processo Json: %s", e.getMessage());
        } catch (IOException e) {
            System.out.printf("\n\nDatabaseController | IOException: %s", e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.printf("\n\nDatabaseController | IOException -> httpClient.close: %s", e.getMessage());
            }
        }
    }

    public Map<Integer, EspecieModel> getDatabase() {
        /*
         * Lê todos os registros do arquivo csv
         */
        try {
            HttpGet request = new HttpGet(url + "/.json"); // Instancia a rquisição
            request.getAllHeaders();

            // Excuta a rquisição
            this.response = httpClient.execute(request);

            int statusCode = this.response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                System.out.printf("\n\nDatabaseController | Requisição executada com suscesso: %s", statusCode);
            } else {
                System.out.printf("\n\nDatabaseController | Falha ao atualizar o recurso. Código de resposta: %s",
                        statusCode);
            }

            String responseBody = EntityUtils.toString(response.getEntity());
            ArrayList<EspecieModel> especiesList = objectMapper.readValue(responseBody, new TypeReference<ArrayList<EspecieModel>>() {});
            int key = 0;
            for (EspecieModel especie : especiesList) {
                this.especies.put(key, especie);
                key++;
            }
            return this.especies;

        } catch (JsonProcessingException e) {
            System.out.printf("\n\nDatabaseController | Erro no processo Json: %s", e.getMessage());
        } catch (IOException e) {
            System.out.printf("\n\nDatabaseController | IOException: %s", e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.printf("\n\nDatabaseController | IOException -> httpClient.close: %s", e.getMessage());
            }
        }
        return null;
    }

}
