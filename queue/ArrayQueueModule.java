package queue;



// Model: a[1]..a[n]
    // Invariant: for i=head..(head + size): a[i] != null

    
public class ArrayQueueModule{
    private static Object[] elements = new Object[16];
    private static int tail = 0;
    private static int head = 0;
    private static int size = 0;

    // Pred: element != null
    // Post: elements
    static public void enqueue(Object element) {
        if (element == null) {
            return;
        }
        ensureCapasity();
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    static private void ensureCapasity() {
        if (size >= elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, head, newElements, 0, size - head);
            System.arraycopy(elements, 0, newElements, size - head, head);
            elements = newElements;
            tail = size;
            head = 0;  
        }
    }
    static public Object element() {
        return elements[head];
    }

    static public Object dequeue() {
        if (size < 1) {
            return null;
        }
        Object result = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return result;
    }

    static public int size() {
        return size;
    }

    static public Boolean isEmpty() {
        return size == 0;
    }

    static public void clear() {
        for (int i = head; i < head + size; i++) {
            i = (i % elements.length);
            elements[i] = null;
        }
        size = 0;
        head = 0;
        tail = 0;
    }
}