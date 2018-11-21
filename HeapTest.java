package Heap;

import java.util.ArrayList;

public class HeapTest {

    private static ArrayList<Integer> keyList = new ArrayList<>();
    private static ArrayList<String> objectList = new ArrayList<>();

    public static void main(String[] args) {

        keyList.add(11);
        keyList.add(66);
        keyList.add(44);
        keyList.add(99);
        keyList.add(33);
        keyList.add(111);
        keyList.add(55);
        keyList.add(88);
        keyList.add(222);
        keyList.add(22);
        for (int i = 0; i < keyList.size(); i++) {
            objectList.add("" + i);
        }

        ArrayList<Integer> list2 = new ArrayList<>();

        Heap<String> heap = new Heap<>(keyList, objectList);
        heap.buildMinHeap();
        list2 = heap.getHeapKeyArray();
        objectList = heap.getHeapObjectArray();
        log("size: " + heap.size());
        for (int i = 1; i < list2.size(); i++) {
            log("index: " + i + ", name: " + objectList.get(i) + " with key: " + list2.get(i));
        }

        log("\n-----After extract min object-----");
        log("min name: " + heap.extractMinObject());
        log("min name: " + heap.extractMinObject());
        log("size: " + heap.size());
        list2 = heap.getHeapKeyArray();
        objectList = heap.getHeapObjectArray();
        for (int i = 1; i < list2.size(); i++) {
            log("index: " + i + ", name: " + objectList.get(i) + " with key: " + list2.get(i));
        }

        log("\n-----After Doing Min Heap Sorting-----");
        log("size: " + heap.size());
        heap.doMinHeapSorting();
        list2 = heap.getHeapKeyArray();
        objectList = heap.getHeapObjectArray();
        for (int i = 1; i < list2.size(); i++) {
            log("index: " + i + ", name: " + objectList.get(i) + " with key: " + list2.get(i));
        }

        heap.decreaseKeyValue(4, 11);
        log("\n-----After decreasing key value -----");
        log("size: " + heap.size());
        list2 = heap.getHeapKeyArray();
        objectList = heap.getHeapObjectArray();
        for (int i = 1; i < list2.size(); i++) {
            log("index: " + i + ", name: " + objectList.get(i) + " with key: " + list2.get(i));
        }

        heap.insertKeyToMinHeap(50, "50");
        log("\n-----After inserting Key To Min Heap -----");
        list2 = heap.getHeapKeyArray();
        objectList = heap.getHeapObjectArray();
        log("size: " + heap.size());
        for (int i = 1; i < list2.size(); i++) {
            log("index: " + i + ", name: " + objectList.get(i) + " with key: " + list2.get(i));
        }

        heap.buildMaxHeap();
        log("\n-----After building max heap -----");
        list2 = heap.getHeapKeyArray();
        objectList = heap.getHeapObjectArray();
        log("size: " + heap.size());
        for (int i = 1; i < list2.size(); i++) {
            log("index: " + i + ", name: " + objectList.get(i) + " with key: " + list2.get(i));
        }

    }

    private static void log(String args) {
        System.out.println(args);
    }

    private static void log(int args) {
        System.out.println(args);
    }
}
