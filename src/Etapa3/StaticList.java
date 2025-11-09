package Etapa3;

public class StaticList {
    private Object[] elements;
    private int size;

    public StaticList(int maxSize) {
        elements = new Object[maxSize];
        size = 0;
    }

    public void insert(Object element, int index) {
        if (isFull() || index < 0 || index > size) return;
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public Object remove(int index) {
        if (isEmpty() || index < 0 || index >= size) return null;
        Object removed = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removed;
    }

    public Object get(int index) {
        return (index >= 0 && index < size) ? elements[index] : null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public int numElements() {
        return size;
    }

    public int contaElementos(Object el) {
        return contaElementosRecursivo(el, 0);
    }

    private int contaElementosRecursivo(Object el, int index) {
        if (index >= size) return 0;
        int count = (elements[index] != null && elements[index].equals(el)) ? 1 : 0;
        return count + contaElementosRecursivo(el, index + 1);
    }
}