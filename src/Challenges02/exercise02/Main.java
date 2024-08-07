package Challenges02.exercise02;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        var gson = new Gson();

        String jsonPublisher = """
                {
                    "name" : "Filos",
                    "city" : "Avaré"
                }
                """;

        String jsonBook = """
                {
                    "title" : "Five Nights at Freddy's Survival Logbook",
                    "author" : "Scott Cawthon",
                    "publisher" : {
                        "name" : "Filos",
                        "city" : "Avaré"
                    }    
                            
                }
                """;

        Book myBook = gson.fromJson(jsonBook, Book.class);
        System.out.println(myBook);
    }
}