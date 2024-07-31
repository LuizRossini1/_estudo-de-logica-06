package Challenges.exercise01;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    private String title = scanner.nextLine();
    private String apiKey = "AIzaSyB7YH_lp2esNcxLa-JxyK5h6SiioXcNJrs";

    public String getTitle() {
        return title;
    }

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + title + "&key=" + apiKey)).build();
    HttpResponse<String> response;

    {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}