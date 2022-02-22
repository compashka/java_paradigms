package queue;

public class ArrayQueueADT {
    private Object[] elements = new Object[1000001];
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    static public void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;
        queue.elements[queue.tail] = element;
        queue.tail = (queue.tail + 1) % 1000001;
        queue.size++;
    }

    static public Object element(ArrayQueueADT queue) {
        return queue.elements[queue.head];
    }

    static public Object dequeue(ArrayQueueADT queue) {
        assert queue.size >= 1;
        Object result = queue.elements[queue.head];
        queue.elements[queue.head] = null;
        queue.head = (queue.head + 1) % 1000001;
        queue.size--;
        return result;
    }

    static public int size(ArrayQueueADT queue) {
        return queue.size;
    }

    static public Boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    static public void clear(ArrayQueueADT queue) {
        for (int i = queue.head; i < queue.head + queue.size; i++) {
            i = (i % 1000001);
            queue.elements[i] = null;
        }
        queue.head = 0;
        queue.tail = 0;
    }
}

