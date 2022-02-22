package queue;

public class ArrayQueue {
    private Object[] elements = new Object[16];
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public void enqueue(Object element) {
        if (element == null) {
            return;
        }
        ensureCapasity();
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    private void ensureCapasity() {
        if (size >= elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, head, newElements, 0, size - head);
            System.arraycopy(elements, 0, newElements, size - head, head);
            elements = newElements;
            tail = size;
            head = 0; 
        }
    }

    public Object element() {
        return elements[head];
    }

    public Object dequeue() {
        if (size < 1) {
            return null;
        }
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
        size = 0;
    }
}
