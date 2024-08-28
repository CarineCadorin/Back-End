package Exercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        RepositorioMusical spotify = new RepositorioMusical();

        spotify.adicionarMusica("Hope", "foo fighters");
        spotify.adicionarMusica("Pra sempre", "Hero");
        spotify.adicionarMusica("Bota na pipoquinha", "Mc Pipoquinha");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome de uma música: \n");
        String termo = scanner.nextLine();

        try {
            Musica musicaPesquisada = spotify.buscarMusica(termo);
            //imprimir a musica que foi encontrada
            System.out.println(musicaPesquisada.getNome() + " - " + musicaPesquisada.getArtista());

        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
    }
}
