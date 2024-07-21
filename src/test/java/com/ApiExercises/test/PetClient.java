package com.ApiExercises.test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class PetClient {

    private static final String petBaseUrl = "https://petstore.swagger.io/v2/pet/findByStatus";

    public static List<Map<String, Object>> getSoldPets() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(petBaseUrl + "?status=sold"))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray petsArray = new JSONArray(response.body());

        List<Map<String, Object>> pets = new ArrayList<>();
        for (int i = 0; i < petsArray.length(); i++) {
            JSONObject pet = petsArray.getJSONObject(i);
            Map<String, Object> petData = new HashMap<>();
            petData.put("id", pet.getInt("id"));
            petData.put("name", pet.getString("name"));
            pets.add(petData);
        }
        return pets;
    }
    
}
