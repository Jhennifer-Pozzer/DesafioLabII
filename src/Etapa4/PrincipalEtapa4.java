package Etapa4;

public class PrincipalEtapa4 {

    public static void main(String[] args) {

        System.out.println("Teste 1: Contagem de Elementos na Pilha (LinkedStack)");
        LinkedStack<Integer> stack = new LinkedStack<>();

        System.out.println("Pilha está vazia? " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Elemento no topo da pilha: " + stack.top());
        System.out.println("Desempilhando: " + stack.pop());
        System.out.println("Número de elementos na pilha: " + stack.numElements());
        System.out.println("---------------------------------------------------");

        System.out.println("Teste 2: Verificação de Elementos na Fila (LinkedQueue)");
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println("Fila está vazia? " + queue.isEmpty());
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        System.out.println("Primeiro da fila: " + queue.front());
        System.out.println("Desenfileirando: " + queue.dequeue());
        System.out.println("Número de elementos na fila: " + queue.numElements());
        System.out.println("Último da fila (back): " + queue.back());
        System.out.println("---------------------------------------------------");
    }
}

