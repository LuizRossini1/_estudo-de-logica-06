/* Crie um programa em Java que utilize as classes HttpClient, HttpRequest
e HttpResponse para fazer uma consulta à API do Google Books.
Solicite ao usuário que insira o título de um livro,
e exiba as informações  disponíveis sobre o livro retornado pela API. */
package Challenges.exercise01;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.getTitle("ola");
    }
}