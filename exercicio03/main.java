package exercicio03;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        List<Barco> barcos = new ArrayList<>();
        barcos.add(new Barco("Barco 1", 2));
        barcos.add(new Barco("Barco 2", 5));
        barcos.add(new Barco("Barco 3", 7));
        barcos.add(new Barco("Barco 4", 12));
        barcos.add(new Barco("Barco 5", 20));

        PortoPequeno portoPequeno = new PortoPequeno("porto pequeno");
        PortoGrande portoGrande = new PortoGrande("porto grande");

        // Atracação dos barcos
        for (Barco barco : barcos) {
            if (!portoPequeno.atracarBarco(barco)) {
                portoGrande.atracarBarco(barco);
            }
        }
    }
}
