package Exercicio2;

//Pojo de Música
public class Musica {
    private String nome;
    private String artista;

    //Contrutor
    public Musica(String nome, String artista){
        System.out.println("Construtor iniciado");
        this.nome = nome;
        this.artista = artista;
    }
    //getter
    public String getNome(){
        return this.nome;
    }
    //getter
    public String getArtista(){
        return this.artista;
    }

    //setter
    public void setNome(String nome){
         this.nome = nome;
    }
    //setter
    public void setArtista(String artista){
        this.artista = artista;
    }
}
