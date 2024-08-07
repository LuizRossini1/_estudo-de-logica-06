/*2 - Crie uma classe Livro que contenha atributos como título, autor e um objeto representando a editora.
Em seguida, implemente um programa que utiliza a biblioteca Gson para converter um JSON aninhado representando
um livro em um objeto do tipo Livro. */
package Challenges02.exercise02;

public record Book(String title, String author) {
    @Override
    public String toString() {
        return "Book's title: " +title+"\n"+
                "Author: " +author;
    }
}