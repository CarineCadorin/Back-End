package exercicio06;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.adicionarFilme(new Filme("Homem Aranha", 20.0, 12));
        cinema.adicionarFilme(new Filme("O Rei Leão", 25.0, 6));
        cinema.adicionarFilme(new Filme("A Bela e a Fera", 18.0, 10));
        cinema.adicionarFilme(new Filme("It: A Coisa", 22.0, 16));
        cinema.adicionarFilme(new Filme("Velozes e Furiosos", 30.0, 14));

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Qual filme você deseja assistir?");
            String nomeFilme = scanner.nextLine();
            Filme filmeEscolhido = cinema.buscarFilme(nomeFilme);

            if (filmeEscolhido == null) {
                System.out.println("Filme não encontrado.");
                return;
            }

            System.out.println("Qual assento você deseja? (A1 a F5)");
            String assento = scanner.nextLine();

            System.out.println("Qual o seu nome?");
            String nomeCliente = scanner.nextLine();

            System.out.println("Qual a sua idade?");
            int idadeCliente = scanner.nextInt();

            Cliente cliente = new Cliente(nomeCliente, idadeCliente);
            Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assento);

            cinema.venderIngresso(ingresso);
            System.out.println("Ingresso vendido com sucesso! " + filmeEscolhido.getNome() + " - " + assento + " - " + nomeCliente);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
