package Challenges02.exercise01;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        var gson = new Gson();

        String json = """
                {
                    "name" : "Rossini",
                    "age" : 20,
                    "city" : "Cerqueira César"
                }       
                """;

        var myPerson = gson.fromJson(json, Person.class);
        System.out.println(myPerson);
    }
}