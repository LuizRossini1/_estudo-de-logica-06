package Challenges02.exercise02;

public record Publisher(String name, String city) {
    @Override
    public String toString() {
        return "Publisher: " +name+"\n"+
                "Where to find: " +city;
    }
}