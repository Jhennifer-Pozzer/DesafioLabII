package Etapa4;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false; // pilha dinâmica nunca enche
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void push(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = top.getElement();
        top = top.getNext();
        size--;
        return element;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return top.getElement();
    }
}