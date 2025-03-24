import java.util.*;
public class MaxHeap {
    List<Integer> heap = new ArrayList<>();
    void insert(int val) {
        heap.add(val);
        Collections.sort(heap, Collections.reverseOrder());
    }
    void delete(int val) {
        heap.remove(Integer.valueOf(val));
        Collections.sort(heap, Collections.reverseOrder());
    }
    void display() {
        System.out.println(heap);
    }
    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        h.insert(5);
        h.insert(3);
        h.insert(8);
        h.insert(1);
        System.out.println("Heap:");
        h.display();
        h.delete(8);
        System.out.println("Heap after deletion:");
        h.display();
    }
}
