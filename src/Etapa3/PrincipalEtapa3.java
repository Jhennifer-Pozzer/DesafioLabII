package Etapa3;

public class PrincipalEtapa3 {
    public static void main(String[] args) {
        // Teste 1: Contagem de elementos em uma lista estática usando recursão
        System.out.println("Teste 1: Contagem de Elementos em uma Lista Estática");
        StaticList lista = new StaticList(10);
        lista.insert(1, 0);
        lista.insert(2, 1);
        lista.insert(3, 2);
        lista.insert(1, 3);
        lista.insert(2, 4);
        int contagem = lista.contaElementos(1);
        System.out.println("O elemento 1 aparece " + contagem + " vezes na lista.");
        System.out.println("---------------------------------------------------");

        // Teste 2: Verificação de parênteses agrupados corretamente
        System.out.println("Teste 2: Verificação de Parênteses Agrupados");
        StaticStack pilha = new StaticStack(5);
        pilha.push('(');
        pilha.push('A');
        pilha.push('+');
        pilha.push('B');
        pilha.push(')');
        Etapa3 etapa3 = new Etapa3();
        boolean resultado = etapa3.checkBrackets(pilha);
        System.out.println("A expressão tem parênteses agrupados corretamente? " + resultado);
        System.out.println("---------------------------------------------------");
    }
}