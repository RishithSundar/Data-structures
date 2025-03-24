import java.util.*;
public class MinHeap {
    List<Integer> heap = new ArrayList<>();
    void insert(int val) {
        heap.add(val);
        Collections.sort(heap);
    }
    void delete(int val) {
        heap.remove(Integer.valueOf(val));
        Collections.sort(heap);
    }
    void display() {
        System.out.println(heap);
    }
    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        h.insert(5);
        h.insert(3);
        h.insert(8);
        h.insert(1);
        System.out.println("Heap:");
        h.display();
        h.delete(3);
        System.out.println("Heap after deletion:");
        h.display();
    }
}
