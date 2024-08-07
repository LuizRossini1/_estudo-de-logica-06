package Challenges02.exercise01;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        var gson = new GsonBuilder()
                .serializeNulls()
                .create();

        String jsonCompleted = """
                {
                    "name" : "Rossini",
                    "age" : 20,
                    "city" : "Cerqueira César"
                }       
                """;

        String jsonMoreElements = """
                {
                    "name" : "Isaac"
                    "age" : 38
                    "gender" : man 
                    "city" : "Avaré"
                }
                """;

        String jsonMissingElements = """
                {
                    "name" : "Joel"
                    "age" : 52
                }
                """;

        var myPerson = gson.fromJson(jsonCompleted, Person.class);
        System.out.println(myPerson);
    }
}