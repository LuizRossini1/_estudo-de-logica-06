package Challenges01.exercise02;

import com.google.gson.Gson;
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
    private String criptoName = scanner.nextLine();

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.coingecko.com/api/v3/simple/price?ids=" +criptoName+ "&vs_currencies=brl"))
            .build();
    HttpResponse<String> response;

    {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            JsonObject jsonResponse = gson.fromJson(responseBody, JsonObject.class);
            JsonObject criptoObject = jsonResponse.getAsJsonObject(criptoName);

            if (criptoObject != null) {
                // Acessa o valor em reais
                String value = criptoObject.get("brl").getAsString();
                System.out.println("Crypto: " +criptoName+
                        "\n Value: " +value);
            } else {
                System.out.println("Crypto not found: " + criptoName);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}