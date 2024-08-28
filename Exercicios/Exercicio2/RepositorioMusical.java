package Exercicio2;

import java.util.ArrayList;

public class RepositorioMusical {
    private ArrayList<Musica> listarMusica = new ArrayList<>();

    public void adicionarMusica(String nome, String artista) {
        Musica musica = new Musica(nome, artista);
        listarMusica.add(musica);
    }
    public Musica buscarMusica(String termo){
        for (Musica item: listarMusica) {
            if (item.getNome().equals(termo)) {
                return item;
            }
        }
        throw new RuntimeException("A música não foi encontrada");
    }
}

