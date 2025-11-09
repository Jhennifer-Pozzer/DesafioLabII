package Etapa4;

public class LinkedQueue<E> implements Queue<E> {

    private Node<E> front;
    private Node<E> back;
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false; // fila dinâmica nunca enche
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void enqueue(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            back.setNext(newNode);
        }
        back = newNode;
        size++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = front.getElement();
        front = front.getNext();
        size--;
        if (front == null) {
            back = null;
        }
        return element;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return front.getElement();
    }

    @Override
    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return back.getElement();
    }
}
