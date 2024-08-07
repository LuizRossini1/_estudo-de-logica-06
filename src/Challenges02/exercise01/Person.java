/*1 - Crie uma classe Person usando o conceito de Record em Java, com atributos como nome, idade e cidade.
Em seguida, implemente um programa que utiliza a biblioteca Gson para converter um JSON representando uma
pessoa em um objeto do tipo Person. */
package Challenges02.exercise01;

public record Person(String name, int age, String city) {
    @Override
    public String toString() {
        return "Name: " +name+ "\n" +
                "Age: " +age+ "\n" +
                "City: " +city;
    }
}