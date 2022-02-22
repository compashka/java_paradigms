package queue;

public class ArrayQueue {
    private Object[] elements = new Object[16];
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public void enqueue(Object element) {
        assert element != null;
        ensureCapasity(head, tail);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    private void ensureCapasity(int head, int tail) {
        if (head == tail + 1) {
            Object[] array = new Object[elements.length * 2];
            System.arraycopy(elements, head, array, 0, size - head);
            System.arraycopy(elements, 0, array, size - head + 1, head);
            elements = array;
            tail = size;
            head = 0; 
        }
    }

    public Object element() {
        return elements[head];
    }

    public Object dequeue() {
        assert size >= 1;
        Object result = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = head; i < head + size; i++) {
            i = (i % elements.length);
            elements[i] = null;
        }
        head = 0;
        tail = 0;
    }
}
