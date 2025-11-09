package Etapa1;

public class PrincipalLabirinto {

    public static void main(String[] args) {

        Labirinto l = new Labirinto();

        // o validador exige este caminho
        String caminho = "src/Etapa1/labirinto.txt";

        l.criaLabirinto(caminho);

        System.out.println("Labirinto Inicial:");
        l.imprimeLabirinto();

        boolean achou = l.percorreLabirinto();

        System.out.println("\nLabirinto Final:");
        l.imprimeLabirinto();
    }
}

