package Heap;

import java.util.ArrayList;

public class HeapTest {

    private static ArrayList<Integer> list = new ArrayList<>();
    private static ArrayList<Integer> nameList = new ArrayList<>();
    private static ArrayList<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {
        list.add(10);
        list.add(12);
        list.add(3);
        list.add(13);
        list.add(8);
        list.add(7);
        list.add(9);
        list.add(5);
        list.add(4);
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            nameList.add(i);
        }


        Heap<Integer> heap = new Heap<>(list, nameList);
        heap.buildMinHeap();
        list2 = heap.getHeapKeyArray();
        nameList = heap.getHeapObjectArray();
        for (int i = 1; i < list2.size(); i++) {
            log("name: " + nameList.get(i) + " with key: " + list2.get(i));
        }

        log("-----After extract min object-----");
        heap.extractMinObject();
        list2 = heap.getHeapKeyArray();
        nameList = heap.getHeapObjectArray();
        for (int i = 1; i < list2.size(); i++) {
            log("name: " + nameList.get(i) + " with key: " + list2.get(i));
        }



    }

    private static void log(String args) {
        System.out.println(args);
    }

    private static void log(int args) {
        System.out.println(args);
    }
}
