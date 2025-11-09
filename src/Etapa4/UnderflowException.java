package Etapa4;

public class UnderflowException extends RuntimeException {
    public UnderflowException(String message) {
        super("Pilha/Fila vazia! Nenhum elemento para remover.");
    }

    public UnderflowException() {

    }
}

