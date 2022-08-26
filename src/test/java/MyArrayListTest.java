import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class MyArrayListTest {

    @Test
    public void mergeSortIntegerTest() {
        MyArrayList<Integer> actual = createIntegerMyArrayListWithElements();
        MyArrayList<Integer> expected = createSortedIntegerMyArrayListWithElements();
        actual.sort();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void mergeSortStringTest() {
        MyArrayList<String> actual = createStringMyArrayListWithElements();
        MyArrayList<String> expected = createSortedStringMyArrayListWithElements();
        actual.sort();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void addingIntegerWithIndexTest() {
        MyArrayList<Integer> actual = createIntegerMyArrayListWithElements();
        MyArrayList<Integer> expected = createIntegerMyArrayListWithAddedElementByIndex();
        actual.add(5, 3);
        assertArrayEquals(actual.toArray(), expected.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addingIntegerOutOfBoundsTest() {
        MyArrayList<Integer> actual = createIntegerMyArrayListWithElements();
        actual.add(4, 923);
    }

    @Test
    public void deleteElementTest() {
        MyArrayList<String> actual = createStringMyArrayListWithElements();
        MyArrayList<String> expected = createStringMyArrayListWithDeletedElement();
        actual.delete("awav");
        assertArrayEquals(actual.toArray(), expected.toArray());
    }

    private MyArrayList<Integer> createIntegerMyArrayListWithElements() {
        MyArrayList<Integer> integerArrayList = new MyArrayList<>();
        integerArrayList.add(4);
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(5);
        integerArrayList.add(0);
        return integerArrayList;
    }

    private MyArrayList<Integer> createIntegerMyArrayListWithAddedElementByIndex() {
        MyArrayList<Integer> integerArrayList = new MyArrayList<>();
        integerArrayList.add(4);
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(5);
        integerArrayList.add(0);
        return integerArrayList;
    }

    private MyArrayList<Integer> createSortedIntegerMyArrayListWithElements() {
        MyArrayList<Integer> integerArrayList = new MyArrayList<>();
        integerArrayList.add(0);
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(4);
        integerArrayList.add(5);
        return integerArrayList;
    }

    private MyArrayList<String> createStringMyArrayListWithElements() {
        MyArrayList<String> stringArrayList = new MyArrayList<>();
        stringArrayList.add("cbb");
        stringArrayList.add("cav");
        stringArrayList.add("awav");
        stringArrayList.add("zwsa");
        stringArrayList.add("jhaw");
        stringArrayList.add("jzad");
        return stringArrayList;
    }

    private MyArrayList<String> createStringMyArrayListWithDeletedElement() {
        MyArrayList<String> stringArrayList = new MyArrayList<>();
        stringArrayList.add("cbb");
        stringArrayList.add("cav");
        stringArrayList.add("zwsa");
        stringArrayList.add("jhaw");
        stringArrayList.add("jzad");
        return stringArrayList;
    }

    private MyArrayList<String> createSortedStringMyArrayListWithElements() {
        MyArrayList<String> stringArrayList = new MyArrayList<>();
        stringArrayList.add("awav");
        stringArrayList.add("cav");
        stringArrayList.add("cbb");
        stringArrayList.add("jhaw");
        stringArrayList.add("jzad");
        stringArrayList.add("zwsa");
        return stringArrayList;
    }
}
