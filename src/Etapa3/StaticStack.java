package Etapa3;

public class StaticStack {
    private Object[] elements;
    private int top;

    public StaticStack(int maxSize) {
        elements = new Object[maxSize];
        top = -1;
    }

    public void push(Object element) {
        if (!isFull()) {
            elements[++top] = element;
        }
    }

    public Object pop() {
        return isEmpty() ? null : elements[top--];
    }

    public Object top() {
        return isEmpty() ? null : elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int numElements() {
        return top + 1;
    }
}