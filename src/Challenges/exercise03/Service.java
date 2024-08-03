package Challenges.exercise03;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Gson gson = new Gson();
    private String recipe = scanner.nextLine();

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.themealdb.com/api/json/v1/1/search.php?s=" +recipe))
            .build();
    HttpResponse<String> response;

    {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            JsonObject jsonResponse = gson.fromJson(responseBody, JsonObject.class);
            JsonArray arrayMeals = jsonResponse.getAsJsonArray("meals");
                for (int i = 0; i < arrayMeals.size(); i++) {
                    JsonObject meal = arrayMeals.get(i).getAsJsonObject();
                    var nameRecipe = meal.get("strMeal").getAsString();
                    var category = meal.get("strCategory").getAsString();
                    var region = meal.get("strArea").getAsString();
                    var instructions = meal.get("strInstructions").getAsString();

                    System.out.println("Recipe: " +nameRecipe+
                            "\n"+
                            "\nCategory: " +category+
                            "\n"+
                            "\nRegion: " +region+
                            "\n"+
                            "\nIntructions: " +instructions);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}