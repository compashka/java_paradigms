package queue;

public class ArrayQueueADT {
    private Object[] elements = new Object[16];
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    static public void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;
        ensureCapasity(queue, queue.head, queue.tail);
        queue.elements[queue.tail] = element;
        queue.tail = (queue.tail + 1) % queue.elements.length;
        queue.size++;
    }
    
    static private void ensureCapasity(ArrayQueueADT queue, int head, int tail) {
        if (head == tail + 1) {
            Object[] array = new Object[queue.elements.length * 2];
            System.arraycopy(queue.elements, head, array, 0, queue.size - head);
            System.arraycopy(queue.elements, 0, array, queue.size - head + 1, head);
            queue.elements = array;
            queue.tail = queue.size;
            queue.head = 0;  
        }
    }

    static public Object element(ArrayQueueADT queue) {
        return queue.elements[queue.head];
    }

    static public Object dequeue(ArrayQueueADT queue) {
        assert queue.size >= 1;
        Object result = queue.elements[queue.head];
        queue.elements[queue.head] = null;
        queue.head = (queue.head + 1) % queue.elements.length;
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
            i = (i % queue.elements.length);
            queue.elements[i] = null;
        }
        queue.head = 0;
        queue.tail = 0;
    }
}

