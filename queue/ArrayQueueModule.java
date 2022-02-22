package queue;


// Model: a[1]..a[n]
    // Invariant: for i=1..n: a[i] != null

    //void enqueue 
public class ArrayQueueModule{
    private static Object[] elements = new Object[1000001];
    private static int tail = 0;
    private static int head = 0;
    private static int size = 0;

    static public void enqueue(Object element) {
        assert element != null;
        elements[tail] = element;
        tail = (tail + 1) % 1000001;
        size++;
    }

    static public Object element() {
        return elements[head];
    }

    static public Object dequeue() {
        assert size >= 1;
        Object result = elements[head];
        elements[head] = null;
        head = (head + 1) % 1000001;
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
            i = (i % 1000001);
            elements[i] = null;
        }
        head = 0;
        tail = 0;
    }
}