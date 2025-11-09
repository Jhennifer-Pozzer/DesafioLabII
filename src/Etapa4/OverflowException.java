package Etapa4;


public class OverflowException extends RuntimeException {
    public OverflowException() {
        super("Capacidade máxima excedida na pilha/fila!");
    }

}