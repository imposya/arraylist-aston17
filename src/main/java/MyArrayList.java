import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int capacity;
    private int size;

    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            elements = (E[]) new Object[capacity];
            this.capacity = capacity;
        } else if (capacity == 0) {
            elements = (E[]) new Object[]{};
            this.capacity = capacity;
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
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    private void increaseCapacityIfNeeded() {
        if (size == elements.length) {
            capacity = (int) (elements.length * 1.5 + 1);
            elements = Arrays.copyOf(elements, (int) (elements.length * 1.5 + 1));
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


    public void delete(E element) {
        //TODO
    }

    public void sort() {
        //TODO
    }
}