package Etapa1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {

    public final char PAREDE = 'X';
    public final char CAMINHO_ABERTO = ' ';
    public final char SAIDA = 'D';
    public final char CAMINHO_SOLUCAO = '#';

    private char[][] labirinto;

    // Lê o arquivo e monta o labirinto.
    public void criaLabirinto(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            // Conta linhas, descobre maior largura
            String linha;
            int linhas = 0;
            int colunas = 0;
            while ((linha = br.readLine()) != null) {
                linhas++;
                if (linha.length() > colunas)
                    colunas = linha.length();
            }
            br.close();

            // Releitura para armazenar no array
            labirinto = new char[linhas][colunas];
            br = new BufferedReader(new FileReader(filename));

            int i = 0;
            while ((linha = br.readLine()) != null) {
                for (int j = 0; j < colunas; j++) {
                    if (j < linha.length())
                        labirinto[i][j] = linha.charAt(j);
                    else
                        labirinto[i][j] = CAMINHO_ABERTO;
                }
                i++;
            }
            br.close();

        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao ler arquivo: " + filename);
        }
    }


     //Percorre o labirinto tentando achar a saída.
     // Inicia sempre em (0,0).
    public boolean percorreLabirinto() {
        if (labirinto == null) return false;

        boolean achou = resolverLabirinto(0, 0);

        if (achou) {
            System.out.println("Solução encontrada");
        } else {
            System.out.println("Não encontrou solução");
        }

        return achou;
    }


     // Função recursiva

    private boolean resolverLabirinto(int x, int y) {

        if (!posicaoValida(x, y))
            return false;

        if (labirinto[x][y] == SAIDA)
            return true;

        if (labirinto[x][y] != CAMINHO_ABERTO)
            return false;

        // Marca caminho
        labirinto[x][y] = CAMINHO_SOLUCAO;

        // Tentativas (N, S, L, O)
        if (resolverLabirinto(x - 1, y)) return true; // Norte
        if (resolverLabirinto(x + 1, y)) return true; // Sul
        if (resolverLabirinto(x, y + 1)) return true; // Leste
        if (resolverLabirinto(x, y - 1)) return true; // Oeste

        // Backtracking
        labirinto[x][y] = CAMINHO_ABERTO;

        return false;
    }

    private boolean posicaoValida(int x, int y) {
        if (x < 0 || y < 0)
            return false;
        if (x >= labirinto.length)
            return false;
        if (y >= labirinto[0].length)
            return false;
        return true;
    }

    // Imprime o labirinto
    public void imprimeLabirinto() {
        if (labirinto == null) return;
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
    }
}
