package Etapa2;

import java.util.Arrays;
import java.util.Comparator;

public class OrdenarCandidatos {

    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        Arrays.sort(candidatos, Comparator.comparing(Candidato::getNome));
    }

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        Arrays.sort(candidatos, Comparator.comparingInt(Candidato::getIntencoesVotos));
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        Arrays.sort(candidatos, Comparator.comparing(Candidato::getPartido));
    }

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nomeBuscado) {
        int left = 0, right = candidatos.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comp = candidatos[mid].getNome().compareTo(nomeBuscado);
            if (comp == 0) return mid;
            else if (comp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
