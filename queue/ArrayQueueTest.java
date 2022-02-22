package queue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue q1 = new ArrayQueue();
        ArrayQueue q2 = new ArrayQueue();
        for (int i = 0; i < 6; i++) {
            q1.enqueue("q_1_" + i);
            q2.enqueue("q_2_" + i);
        }
        System.out.println("size q1: " + q1.size());
        System.out.println("isEmpty q1: "+ q1.isEmpty());
        System.out.println("size q2: " + q2.size());
        System.out.println("isEmpty q2: "+ q2.isEmpty());

        for (int i = 0; i < 6; i++) {
            System.out.println(q1.dequeue());
            System.out.println(q2.dequeue());
        }

        System.out.println("head q1: " + q1.element());
        System.out.println("head q2: " + q2.element());
    }

}
