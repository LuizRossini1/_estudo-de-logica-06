package Challenges01.exercise01;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Gson gson = new Gson();
    private String title = scanner.nextLine();
    private String apiKey = "";

    public String getTitle() {
        return title;
    }

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + title + "&maxResults=1&key=" + apiKey))
            .build();
    HttpResponse<String> response;

    {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            JsonObject jsonResponse = gson.fromJson(responseBody, JsonObject.class);
            JsonArray items = jsonResponse.getAsJsonArray("items");
            for (int i = 0; i < items.size(); i++) {
                JsonObject item = items.get(i).getAsJsonObject();
                JsonObject volumeInfo = item.getAsJsonObject("volumeInfo");
                String title = volumeInfo.get("title").getAsString();
                String authors = volumeInfo.getAsJsonArray("authors").toString();
                System.out.println("Title: " + title + ", Authors: " + authors);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}