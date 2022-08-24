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
        for (int i = size; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    private void increaseCapacityIfNeeded() {
        if (size == elements.length) {
            capacity = (int) (elements.length * 1.5 + 1);
            E[] temp = (E[]) new Object[(int) (elements.length * 1.5 + 1)];
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
                delete(i);
                return true;
            }
        }
        return false;
    }

    private void delete(int index) {
        if (size - 1 > index) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i+1];
            }
        }
        elements[size-1] = null;
        size--;
    }

    public void sort() {
        //TODO
    }
}