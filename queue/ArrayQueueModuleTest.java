package queue;

public class ArrayQueueModuleTest {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            ArrayQueueModule.enqueue("q_1_" + i);
        }
        System.out.println("size q1: " + ArrayQueueModule.size());
        System.out.println("isEmpty q1: "+ ArrayQueueModule.isEmpty());

        for (int i = 0; i < 6; i++) {
            System.out.println(ArrayQueueModule.dequeue());
        }

        System.out.println("head queue: " + ArrayQueueModule.element());
    }
}
