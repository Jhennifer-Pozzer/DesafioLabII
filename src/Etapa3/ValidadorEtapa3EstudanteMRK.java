package Etapa3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ValidadorEtapa3EstudanteMRK {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_VERDE = "\u001B[32m";
    private static final String ANSI_VERMELHO = "\u001B[31m";
    private static final String ANSI_LARANJA = "\u001B[38;5;208m";

    private static int totalTestes = 0;
    private static int acertos = 0;

    public static void main(String[] args) {
        imprimeLinha("+----------------------------------------------------------+");
        imprimeLinha("|                Etapa 3 | Validador com Nota              |");
        imprimeLinha("+----------------------------------------------------------+");

        validaClasse("StaticList");
        validaAtributo("StaticList", "elements");
        validaClasse("PrincipalEtapa3");
        validaMetodo("StaticList", "insert", Object.class, int.class);
        validaMetodoPublico("StaticList", "contaElementos", Object.class);
        validaMetodoPrivado("StaticList", "contaElementosRecursivo", Object.class, int.class);

        validaClasse("StaticStack");
        validaMetodo("StaticStack", "isEmpty");
        validaMetodo("StaticStack", "isFull");
        validaMetodo("StaticStack", "numElements");
        validaMetodo("StaticStack", "push", Object.class);
        validaMetodo("StaticStack", "pop");
        validaMetodo("StaticStack", "top");

        validaClasse("Etapa3");

        // Verificação segura da interface Stack
        try {
            Class<?> stackClass = Class.forName("Etapa3.Stack");
            validaMetodo("Etapa3", "checkBrackets", stackClass);
        } catch (ClassNotFoundException e) {
            System.out.println(formatarMensagem("[NOK] Interface Stack não encontrada.", false));
            contabiliza(false);
        }

        imprimeLinha("+----------------------------------------------------------+");
        double nota = totalTestes > 0 ? 1.5 * ((double) acertos / totalTestes) : 0.0;
        System.out.printf(ANSI_LARANJA + "| %-56s |\n",
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
            Class.forName("Etapa3." + nomeClasse);
            System.out.println(formatarMensagem("[OK] Classe " + nomeClasse + " encontrada.", true));
            contabiliza(true);
        } catch (ClassNotFoundException e) {
            System.out.println(formatarMensagem("[NOK] Classe " + nomeClasse + " não encontrada.", false));
            contabiliza(false);
        }
    }

    private static void validaMetodoPublico(String nomeClasse, String nomeMetodo, Class<?>... parametros) {
        try {
            Class<?> classe = Class.forName("Etapa3." + nomeClasse);
            Method metodo = classe.getDeclaredMethod(nomeMetodo, parametros);
            if (Modifier.isPublic(metodo.getModifiers())) {
                System.out.println(formatarMensagem("[OK] Método " + nomeMetodo + " (público) encontrado.", true));
                contabiliza(true);
            } else {
                System.out.println(formatarMensagem("[NOK] Método " + nomeMetodo + " não é público.", false));
                contabiliza(false);
            }
        } catch (Exception e) {
            System.out.println(formatarMensagem("[NOK] Método " + nomeMetodo + " (público) não encontrado.", false));
            contabiliza(false);
        }
    }

    private static void validaMetodoPrivado(String nomeClasse, String nomeMetodo, Class<?>... parametros) {
        try {
            Class<?> classe = Class.forName("Etapa3." + nomeClasse);
            Method metodo = classe.getDeclaredMethod(nomeMetodo, parametros);
            if (Modifier.isPrivate(metodo.getModifiers())) {
                System.out.println(formatarMensagem("[OK] Método " + nomeMetodo + " (privado) encontrado.", true));
                contabiliza(true);
            } else {
                System.out.println(formatarMensagem("[NOK] Método " + nomeMetodo + " não é privado.", false));
                contabiliza(false);
            }
        } catch (Exception e) {
            System.out.println(formatarMensagem("[NOK] Método " + nomeMetodo + " (privado) não encontrado.", false));
            contabiliza(false);
        }
    }

    private static void validaMetodo(String nomeClasse, String nomeMetodo, Class<?>... parametros) {
        try {
            Class<?> classe = Class.forName("Etapa3." + nomeClasse);
            classe.getDeclaredMethod(nomeMetodo, parametros);
            System.out.println(formatarMensagem("[OK] Método " + nomeMetodo + " encontrado.", true));
            contabiliza(true);
        } catch (Exception e) {
            System.out.println(formatarMensagem("[NOK] Método " + nomeMetodo + " não encontrado.", false));
            contabiliza(false);
        }
    }

    private static void validaAtributo(String nomeClasse, String nomeAtributo) {
        try {
            Class<?> classe = Class.forName("Etapa3." + nomeClasse);
            Field campo = classe.getDeclaredField(nomeAtributo);
            System.out.println(formatarMensagem("[OK] Atributo " + nomeAtributo + " encontrado.", true));
            contabiliza(true);
        } catch (Exception e) {
            System.out.println(formatarMensagem("[NOK] Atributo " + nomeAtributo + " não encontrado.", false));
            contabiliza(false);
        }
    }

    private static String formatarMensagem(String mensagem, boolean ok) {
        return String.format((ok ? ANSI_VERDE : ANSI_VERMELHO) + "| %-56s |" + ANSI_RESET, mensagem);
    }

    private static void imprimeLinha(String linha) {
        System.out.println(ANSI_LARANJA + linha + ANSI_RESET);
    }
}