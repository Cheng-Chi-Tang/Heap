package Heap;

import java.util.ArrayList;

public class Heap<T> {
    private int size;
    private ArrayList<Integer> heapKeyArray = new ArrayList<>();
    private static final int MINUS_INFINITY = -(int) Math.pow(2, 32) - 1;
    private static final int INFINITY = (int) Math.pow(2, 32);
    private ArrayList<T> heapObjectList = new ArrayList<>();

    public Heap(ArrayList<Integer> arrayList) {
        heapKeyArray.add(null);
        heapKeyArray.addAll(arrayList);
        this.size = arrayList.size();
    }

    public Heap(ArrayList<Integer> keyList, ArrayList<T> objectList) {
        heapKeyArray.add(null);
        heapKeyArray.addAll(keyList);
        if (keyList.size() != objectList.size()) {
            log("Error: keyList size != objectList size. Assign key to object ");
            heapObjectList.add(null);
        } else {
            heapObjectList.add(null);
            heapObjectList.addAll(objectList);
            this.size = keyList.size();
        }
    }

    private int getParentIndex(int index) {
        return (int) Math.ceil(index / 2);
    }

    private int getLeftIndex(int index) {
        return 2 * index;
    }

    private int getRightIndex(int index) {
        return 2 * index + 1;
    }

    public void doMinHeapifying(int rootIndex) {
        if (rootIndex > size || rootIndex < 1) {
            log("The root index is invalid.");
            return;
        }

        int left = getLeftIndex(rootIndex);
        int right = getRightIndex(rootIndex);
        int minimumIndex = rootIndex;

        if (left <= size && heapKeyArray.get(rootIndex) > heapKeyArray.get(left)) {
            minimumIndex = left;
        }

        if (right <= size && heapKeyArray.get(minimumIndex) > heapKeyArray.get(right)) {
            minimumIndex = right;
        }

        if (minimumIndex != rootIndex) {
            swap(heapKeyArray, rootIndex, minimumIndex);
            swapObject(heapObjectList, rootIndex, minimumIndex);
            doMinHeapifying(minimumIndex);
        }
    }

    public void doMaxHeapifying(int rootIndex) {
        if (rootIndex == 0) {
//            log("Index 0 is not acceptable.");
            return;
        }
        if (rootIndex >= size) {
//            log("root index is out of bound");
            return;
        }

        int left = getLeftIndex(rootIndex);
        int right = getRightIndex(rootIndex);
        int largest = rootIndex;

        if (left <= size && heapKeyArray.get(rootIndex) < heapKeyArray.get(left)) {
            largest = left;
        }

        if (right <= size && heapKeyArray.get(largest) < heapKeyArray.get(right)) {
            largest = right;
        }

        if (largest != rootIndex) {
            swap(heapKeyArray, rootIndex, largest);
            swapObject(heapObjectList, rootIndex, largest);
            doMaxHeapifying(largest);
        }
    }

    public void buildMinHeap() {
        size = heapKeyArray.size() - 1;
        for (int i = (int) Math.floor(size / 2); i >= 1; i--) {
            doMinHeapifying(i);
        }
    }

    public void buildMaxHeap() {
        size = heapKeyArray.size() - 1;
        for (int i = (int) Math.floor(size / 2); i >= 1; i--) {
            doMaxHeapifying(i);
        }
    }

    public void doMinHeapSorting() {
        buildMinHeap();
        for (int i = heapKeyArray.size() - 1; i >= 2; i--) {
            swap(heapKeyArray, i, 1);
            swapObject(heapObjectList, i, 1);
            size--;
            doMinHeapifying(1);
        }
        size = heapKeyArray.size()-1;
    }

    public void doMaxHeapSorting() {
        buildMaxHeap();
        for (int i = heapKeyArray.size() - 1; i >= 2; i--) {
            swap(heapKeyArray, i, 1);
            swapObject(heapObjectList, i, 1);
            size--;
            doMaxHeapifying(1);
        }
    }

    // TODO
    public void insertKeyToMinHeap(int newKey) {
        heapKeyArray.add(INFINITY);
        size++;
        increaseKeyValue(size, newKey);
    }

    // TODO
    public void insertKeyToMinHeap(int newKey, T object) {
        heapKeyArray.add(INFINITY);
        heapObjectList.add(object);
        size++;
        decreaseKeyValue(size, newKey);
    }

    // TODO
    public void insertKeyToMaxHeap(int newKey) {
        heapKeyArray.add(MINUS_INFINITY);
        size++;
        increaseKeyValue(size, newKey);
    }

    // TODO
    public void insertKeyToMaxHeap(int newKey, T object) {
        heapKeyArray.add(MINUS_INFINITY);
        heapObjectList.add(object);
        size++;
        increaseKeyValue(size, newKey);
    }

    // TODO
    public void decreaseKeyValue(int index, int newKey) {
        if (newKey > heapKeyArray.get(index)) {
            log("Error: New key is larger than current key");
            return;
        }

        heapKeyArray.set(index, newKey);
        log("index: " + index);
        int i = index;
        while (i > 1 && heapKeyArray.get(getParentIndex(i)) > heapKeyArray.get(i)) {
            swap(heapKeyArray, getParentIndex(i), i);
            swapObject(heapObjectList, getParentIndex(i), i);
            i = getParentIndex(i);
        }
    }

    // TODO
    public void increaseKeyValue(int index, int newKey) {
        if (newKey < heapKeyArray.get(index)) {
            log("Error: New key is smaller than current key");
            return;
        }

        heapKeyArray.set(index, newKey);
        int i = index;
        while (i > 1 && heapKeyArray.get(getParentIndex(i)) < heapKeyArray.get(i)) {
            swap(heapKeyArray, getParentIndex(i), i);
            swapObject(heapObjectList, getParentIndex(i), i);
            i = getParentIndex(i);
        }
    }

    public int extractMin() {
        if (size < 1) {
            log("Error: heap underflow");
            return MINUS_INFINITY;
        }

        int min = heapKeyArray.get(1);
        heapKeyArray.set(1, heapKeyArray.get(size));
        heapKeyArray.set(size, -1);
        size--;
        doMinHeapifying(1);
        return min;
    }

    public T extractMinObject() {
        if (size < 1) {
            log("Error: heap underflow");
            return null;
        }

        T minObject = heapObjectList.get(1);
        heapObjectList.set(1, heapObjectList.get(size));
        heapObjectList.remove(size);
        heapKeyArray.set(1, heapKeyArray.get(size));
        heapKeyArray.remove(size);
        size--;
        doMinHeapifying(1);
        return minObject;
    }

    public int extractMax() {
        if (size < 1) {
            log("Error: heap underflow");
            return -1;
        }

        int max = heapKeyArray.get(1);
        heapKeyArray.set(1, heapKeyArray.get(size));
        heapKeyArray.set(size, MINUS_INFINITY);
        size--;
        doMaxHeapifying(1);
        return max;
    }

    public int getMaximum() {
        return heapKeyArray.get(1);
    }

    public ArrayList<Integer> getHeapKeyArray() {
        return heapKeyArray;
    }

    public ArrayList<T> getHeapObjectArray() {
        return heapObjectList;
    }

    public int size(){
        return size;
    }

    private void swap(ArrayList<Integer> arrayList, int index1, int index2) {
        if (index1 > heapKeyArray.size() || index2 > heapKeyArray.size()) {
            return;
        }
        int element1 = arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2, element1);
    }

    private void swapObject(ArrayList<T> arrayList, int index1, int index2) {
        if (index1 > arrayList.size() || index2 > arrayList.size()) {
            return;
        }
        T element1 = arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2, element1);
    }

    private void log(String args) {
        System.out.println(args);
    }

    private void log(int args) {
        System.out.println(args);
    }

}
// git commit -m 'Rev.2 Fixed some bugs for insertKeyToMinHeap and doMinHeapSorting'