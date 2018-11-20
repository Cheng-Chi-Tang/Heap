package Heap;

import java.util.ArrayList;

public class HeapTest {

    private static ArrayList<Integer> list = new ArrayList<>();
    private static ArrayList<String> nameList = new ArrayList<>();
    private static ArrayList<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {

        list.add(11);
        list.add(66);
        list.add(44);
        list.add(99);
        list.add(33);
        list.add(111);
        list.add(55);
        list.add(88);
        list.add(222);
        list.add(22);
        for (int i = 0; i < list.size(); i++) {
            nameList.add("" + i);
        }


        Heap<String> heap = new Heap<>(list, nameList);
        heap.buildMinHeap();
        list2 = heap.getHeapKeyArray();
        nameList = heap.getHeapObjectArray();
        log("size: " + heap.size());
        for (int i = 1; i < list2.size(); i++) {
            log("name: " + nameList.get(i) + " with key: " + list2.get(i));
        }

        log("\n-----After extract min object-----");
        log("min name: "+ heap.extractMinObject());
        log("min name: "+ heap.extractMinObject());
        log("size: " + heap.size());
        list2 = heap.getHeapKeyArray();
        nameList = heap.getHeapObjectArray();
        for (int i = 1; i < list2.size(); i++) {
            log("name: " + nameList.get(i) + " with key: " + list2.get(i));
        }

        log("\n-----After Doing Min Heap Sorting-----");
        log("size: " + heap.size());
        heap.doMinHeapSorting();
        list2 = heap.getHeapKeyArray();
        nameList = heap.getHeapObjectArray();
        for (int i = 1; i < list2.size(); i++) {
            log("name: " + nameList.get(i) + " with key: " + list2.get(i));
        }

        log("\n-----After decreaseKeyValue -----");
        log("size: " + heap.size());
        heap.decreaseKeyValue(4, 11);
        list2 = heap.getHeapKeyArray();
        nameList = heap.getHeapObjectArray();
        for (int i = 1; i < list2.size(); i++) {
            log("name: " + nameList.get(i) + " with key: " + list2.get(i));
        }

        log("\n-----After inserting Key To Min Heap -----");
        log("size: " + heap.size());
        heap.insertKeyToMinHeap(50, "50");
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
