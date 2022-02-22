package queue;

public class ArrayQueue {
    private Object[] elements = new Object[1000001];
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public void enqueue(Object element) {
        assert element != null;
        elements[tail] = element;
        tail = (tail + 1) % 1000001;
        size++;
    }

    public Object element() {
        return elements[head];
    }

    public Object dequeue() {
        assert size >= 1;
        Object result = elements[head];
        elements[head] = null;
        head = (head + 1) % 1000001;
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
            i = (i % 1000001);
            elements[i] = null;
        }
        head = 0;
        tail = 0;
    }
}
