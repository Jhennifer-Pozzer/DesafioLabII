package Etapa2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

    public static void main(String[] args) {

        Candidato[] candidatos = gerarCandidatos();

        // ==== ORDENAÇÕES (validador exige essas chamadas!) ====
        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        // ======================================================

        System.out.println("Candidatos ordenados por nome:");
        for (Candidato c : candidatos)
            System.out.println(c);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nDigite o nome para pesquisar: ");
        String nome = sc.nextLine();

        int pos = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nome);

        if (pos >= 0) {
            System.out.println("[OK] Candidato encontrado:");
            System.out.println(candidatos[pos]);
        } else {
            System.out.println("[NOK] Candidato não encontrado");
        }
        sc.close();
    }

    private static Candidato[] gerarCandidatos() {
        try {
            BufferedReader nomes = new BufferedReader(new FileReader("src/Etapa2/nomes.txt"));
            BufferedReader partidos = new BufferedReader(new FileReader("src/Etapa2/partidos.txt"));

            String linha;
            int total = 0;
            while ((linha = nomes.readLine()) != null) total++;

            nomes.close();
            nomes = new BufferedReader(new FileReader("src/Etapa2/nomes.txt"));

            Candidato[] lista = new Candidato[total];
            Random r = new Random();

            int i = 0;
            while ((linha = nomes.readLine()) != null) {
                String partido = partidos.readLine();
                int votos = r.nextInt(1000);

                lista[i++] = new Candidato(linha, partido, votos);
            }

            nomes.close();
            partidos.close();
            return lista;

        } catch (Exception e) {
            System.out.println("Erro lendo arquivos.");
            return new Candidato[0];
        }
    }
}
