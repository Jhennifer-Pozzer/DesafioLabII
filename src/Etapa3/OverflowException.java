package Etapa3;

public class OverflowException extends RuntimeException {
    public OverflowException() {
        super("Capacidade máxima excedida!");
    }
}
