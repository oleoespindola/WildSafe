package controller;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
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

    public void sincronizar() {
        String url = "https://wildsafeapp-default-rtdb.firebaseio.com/"; // URL do banco

        // Instanciamento de uma lista de objetos do arquivo CSV
        ReadCsvController readCSV = new ReadCsvController();

        Map<Integer, EspecieModel> especies = new HashMap<>();
        especies.putAll(readCSV.readCSV("csv/lista-de-especies-ameacas-2020.csv"));

        ObjectMapper objectMapper = new ObjectMapper();

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            for (Entry<Integer, EspecieModel> especie : especies.entrySet()) {
                try {
                    int key = especie.getKey();
                    String value = objectMapper.writeValueAsString(especie);
    
                    HttpPut request = new HttpPut(url + key + "/.json");
                    request.setHeader("Content-Type", "application/json");
    
                    HttpEntity entity = new StringEntity(value, ContentType.APPLICATION_JSON);
                    request.setEntity(entity);
    
                    // Executar a requisição PUT
                    HttpResponse response = httpClient.execute(request);
                    
                    int statusCode = response.getStatusLine().getStatusCode();
                    if (statusCode == 200) {
                        System.out.println("Recurso atualizado com sucesso!");
                        String responseBody = EntityUtils.toString(response.getEntity());
                        System.out.println("Resposta do servidor: " + responseBody);
                    } else {
                        System.out.println("Falha ao atualizar o recurso. Código de resposta: " + statusCode);
                    }
                } catch (JsonProcessingException e) {
                    System.out.println("Erro ao criar o cliente HTTP: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar o cliente HTTP: " + e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar o cliente HTTP: " + e.getMessage());
            }

        }
    }

}
