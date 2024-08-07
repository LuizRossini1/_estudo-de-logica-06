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
                    "name" : "Isaac",
                    "age" : 38,
                    "gender" : "man",
                    "city" : "Avaré"
                }
                """;

        String jsonMissingElements = """
                {
                    "name" : "Joel",
                    "age" : 52
                }
                """;

        //json completed
        var myPerson01 = gson.fromJson(jsonCompleted, Person.class);
        System.out.println(myPerson01+ "\n");

        //json with more elements
        var myPerson02 = gson.fromJson(jsonMoreElements, Person.class);
        System.out.println(myPerson02+ "\n");

        //json missing elements
        var myPerson03 = gson.fromJson(jsonMissingElements, Person.class);
        System.out.println(myPerson03);
    }
}