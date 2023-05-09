/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author leo0m
 */
public class EspeciesControllers {
    
    private String dblink = "https://wildsafeapp-default-rtdb.firebaseio.com/.json";
    
    public void db() throws MalformedURLException {
        URL url = new URL(dblink);
        ObjectMapper objectMapper = new ObjectMapper();
    }
    
}
