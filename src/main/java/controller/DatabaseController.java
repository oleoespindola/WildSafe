package controller;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

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
import com.fasterxml.jackson.databind.ObjectMapper;

import model.EspecieModel;

public class DatabaseController {
    /*
     * Lê, grava, altera e deleta os registros no banco de dados do projeto
     */

    String url = "https://wildsafeapp-default-rtdb.firebaseio.com/"; // URL do banco

    ObjectMapper objectMapper = new ObjectMapper();
    CloseableHttpClient httpClient = HttpClients.createDefault();

    public void setDatabase() {
        String csv = "csv/lista-de-especies-ameacas-2020.csv";

        Map<String, EspecieModel> especies = new HashMap<>(); // Instancia o molde dos dados
        ReadCsvController readCSV = new ReadCsvController(); // Instacia classe de leitura de csv

        // Transforma o arquivo csv em objeto
        especies.putAll(readCSV.readCSV(csv));
        /*
         * Grava o arquivo csv no banco de dados
         */

        try {

            String value = objectMapper.writeValueAsString(especies);

            HttpPut request = new HttpPut(url + "/.json"); // Instancia a rquisição
            request.setHeader("Content-Type", "application/json");

            // Declara a entidade HTTP
            HttpEntity entity = new StringEntity(value, ContentType.APPLICATION_JSON);
            request.setEntity(entity);

            // Executar a requisição
            HttpResponse response = httpClient.execute(request);

            // verificar o status da rquisição
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                System.out.printf("\n\nRecurso atualizado com sucesso!\nRegistro: %s",
                        EntityUtils.toString(response.getEntity()));
            } else {
                System.out.println("\n\nFalha ao atualizar o recurso. Código de resposta: " + statusCode);
            }

        } catch (JsonProcessingException e) {
            System.out.println("\n\nErro ao criar o cliente HTTP: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("\n\nErro ao criar o cliente HTTP: " + e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.println("\n\nErro ao fechar o cliente HTTP: " + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, EspecieModel> getDatabase() {
        /*
         * Lê todos os registros do arquivo csv
         */
        try {
            HttpGet request = new HttpGet(url + "/.json"); // Instancia a rquisição
            request.getAllHeaders();

            // Excuta a rquisição
            HttpResponse response = httpClient.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                System.out.printf("\n\nRequisição executada com suscesso! %s", statusCode);
            } else {
                System.out.println("\n\nFalha ao atualizar o recurso. Código de resposta: " + statusCode);
            }

            Map<String, EspecieModel> especies = objectMapper.readValue(response.toString(), HashMap.class);
            return especies;

        } catch (JsonProcessingException e) {
            System.out.println("\n\nErro ao criar o cliente HTTP: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("\n\nErro ao criar o cliente HTTP: " + e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.println("\n\nErro ao fechar o cliente HTTP: " + e.getMessage());
            }
        }
        return null;
    }

}
