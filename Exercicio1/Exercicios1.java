package Exercicio1;
import java.util.Scanner;
public class Exercicios1 {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Qual ambiente você prefere?");
        System.out.println("1 - Sci-fi");
        System.out.println("2 - Medieval");
        int opcaoAmbientacao = leitor.nextInt();

        System.out.println("Qual gênero você prefere?");
        System.out.println("1 - Comédia");
        System.out.println("2 - Drama");
        int opcaoGenero = leitor.nextInt();

        if (opcaoAmbientacao == 1 && opcaoGenero == 1) {
            System.out.println("Homens de preto");
        } else if (opcaoAmbientacao == 1 && opcaoGenero == 2) {
            System.out.println("Arrival");
        } else if (opcaoAmbientacao == 2 && opcaoGenero == 1) {
            System.out.println("Shrek");
        } else if (opcaoAmbientacao == 2 && opcaoGenero == 2) {
            System.out.println("Gladiador");
        } else {
            System.out.println("Opção inválida");
        }

        leitor.close();
    }
}