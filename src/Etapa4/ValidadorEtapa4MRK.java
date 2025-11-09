package Etapa4;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ValidadorEtapa4MRK {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_VERDE = "\u001B[32m";
    private static final String ANSI_VERMELHO = "\u001B[31m";
    private static final String ANSI_LARANJA = "\u001B[38;5;208m";

    private static int totalTestes = 0;
    private static int acertos = 0;

    public static void main(String[] args) {
        imprimeLinha("+----------------------------------------------------------+");
        imprimeLinha("|                Etapa 4 | Validador com Nota              |");
        imprimeLinha("+----------------------------------------------------------+");

        validaClasse("Node");
        validaAtributo("Node", "element");
        validaAtributo("Node", "next");

        validaClasse("Stack");
        validaClasse("Queue");

        validaClasse("LinkedStack");
        validaMetodo("LinkedStack", "push", Object.class);
        validaMetodo("LinkedStack", "pop");
        validaMetodo("LinkedStack", "top");
        validaMetodo("LinkedStack", "isEmpty");
        validaMetodo("LinkedStack", "isFull");
        validaMetodo("LinkedStack", "numElements");

        validaClasse("LinkedQueue");
        validaMetodo("LinkedQueue", "enqueue", Object.class);
        validaMetodo("LinkedQueue", "dequeue");
        validaMetodo("LinkedQueue", "first");
        validaMetodo("LinkedQueue", "front");
        validaMetodo("LinkedQueue", "back");
        validaMetodo("LinkedQueue", "isEmpty");
        validaMetodo("LinkedQueue", "isFull");
        validaMetodo("LinkedQueue", "numElements");

        validaClasse("PrincipalEtapa4");

        imprimeLinha("+----------------------------------------------------------+");
        double nota = totalTestes > 0 ? 1.5 * ((double) acertos / totalTestes) : 0.0;
        System.out.printf(ANSI_LARANJA + "| %-56s | ",
                String.format("Nota final: %.2f/1.50 (%d acertos em %d testes)", nota, acertos, totalTestes));
        imprimeLinha("+----------------------------------------------------------+");
    }

    private static void contabiliza(boolean sucesso) {
        totalTestes++;
        if (sucesso)
            acertos++;
    }

    private static void validaClasse(String nomeClasse) {
        try {
            Class.forName("Etapa4." + nomeClasse);
            System.out.println(formatar("[OK] Classe " + nomeClasse + " encontrada.", true));
            contabiliza(true);
        } catch (ClassNotFoundException e) {
            System.out.println(formatar("[NOK] Classe " + nomeClasse + " não encontrada.", false));
            contabiliza(false);
        }
    }

    private static void validaMetodo(String classe, String metodo, Class<?>... parametros) {
        try {
            Class<?> cls = Class.forName("Etapa4." + classe);
            cls.getDeclaredMethod(metodo, parametros);
            System.out.println(formatar("[OK] Método " + metodo + " encontrado em " + classe + ".", true));
            contabiliza(true);
        } catch (Exception e) {
            System.out.println(formatar("[NOK] Método " + metodo + " não encontrado em " + classe + ".", false));
            contabiliza(false);
        }
    }

    private static void validaAtributo(String nomeClasse, String nomeAtributo) {
        try {
            Class<?> cls = Class.forName("Etapa4." + nomeClasse);
            Field campo = cls.getDeclaredField(nomeAtributo);
            System.out.println(formatar("[OK] Atributo " + nomeAtributo + " encontrado em " + nomeClasse + ".", true));
            contabiliza(true);
        } catch (Exception e) {
            System.out.println(
                    formatar("[NOK] Atributo " + nomeAtributo + " não encontrado em " + nomeClasse + ".", false));
            contabiliza(false);
        }
    }

    private static String formatar(String mensagem, boolean ok) {
        return (ok ? ANSI_VERDE : ANSI_VERMELHO) + "| " + String.format("%-56s", mensagem) + " |" + ANSI_RESET;
    }

    private static void imprimeLinha(String linha) {
        System.out.println(ANSI_LARANJA + linha + ANSI_RESET);
    }
}