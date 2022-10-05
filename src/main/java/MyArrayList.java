import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E extends Comparable<? super E>> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    public MyArrayList() {
        elements = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            elements = (E[]) new Comparable[capacity];
        } else if (capacity == 0) {
            elements = (E[])new Comparable[]{};
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void add(E e) {
        increaseCapacityIfNeeded();
        elements[size] = e;
        size++;
    }

    public void add(E element, int index) {
        boundsCheck(index);
        increaseCapacityIfNeeded();
        for (int i = size; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    private void increaseCapacityIfNeeded() {
        if (size == elements.length) {
            E[] temp = (E[]) new Comparable[(int) (elements.length * 1.5 + 1)];
            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }
    }

    private void boundsCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
    }

    public E get(int index) {
        return elements[index];
    }

    public int size() {
        return size;
    }


    public boolean delete(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                deleteByIndex(i);
                return true;
            }
        }
        return false;
    }

    public E[] toArray() {
        return elements;
    }

    private void deleteByIndex(int index) {
        if (size - 1 > index) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i+1];
            }
        }
        elements[size-1] = null;
        size--;
    }

    public void sort() {
        mergeSort(elements, size);
    }

    private void mergeSort(E[] array, int length) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        E[] leftArray = (E[]) new Comparable[mid];
        E[] rightArray = (E[]) new Comparable[length - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < length; i++) {
            rightArray[i - mid] = array[i];
        }
        mergeSort(leftArray, mid);
        mergeSort(rightArray, length - mid);

        merge(array, leftArray, rightArray, mid, length - mid);
    }
    private void merge(E[] array, E[] leftArr, E[] rightArr, int leftSize, int rightSize) {
        Comparable[] leftArray = Arrays.copyOf(leftArr, leftArr.length);
        Comparable[] rightArray = Arrays.copyOf(rightArr, rightArr.length);

        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i].compareTo(rightArray[j]) <=0 ) {
                array[k++] = leftArr[i++];
            }
            else {
                array[k++] = rightArr[j++];
            }
        }
        while (i < leftSize) {
            array[k++] = leftArr[i++];
        }
        while (j < rightSize) {
            array[k++] = rightArr[j++];
        }
    }
}