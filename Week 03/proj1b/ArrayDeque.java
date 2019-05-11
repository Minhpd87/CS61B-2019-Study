public class ArrayDeque<T> implements Deque<T> {
    private T[] itemsArray;
    private int size;
    private int resizeFactor = 2;
    private double shrinkFactor = 0.25;
    private double usage;
    /* the point is having first index and last index in the middle of the array
    let us add item to the first and last of the array much faster since we don't
    have to shift the elements of the array around if we keep first index as 0 and last index as the size of
    the items.
    Eg:
    0 0 0 0 firstIndex lastIndex 0 0 0 0
    addFirst
    0 0 0 0 1 lastIndex 0 0 0 0
    addFirst
    0 0 0 2 1 lastIndex 0 0 0 0
    addLast
    0 0 0 2 1 3 0 0 0 0
    addLast
    0 0 0 2 1 3 4 0 0 0
    addLast
    0 0 0 2 1 3 4 6 0 0
    addLast, add Last
    0 0 0 2 1 3 4 6 7 8
    addLast
    9 0 0 2 1 3 4 6 7 8
    addFirst
    9 0 1 2 1 3 4 6 7 8
     */
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque() {
        size = 0;
        itemsArray = (T[]) new Object[11];
        //put first and last index in middle of the list
        firstIndex = itemsArray.length / 2; //4
        lastIndex = firstIndex + 1; //5
    }

    public static void main(String[] args) {
        ArrayDeque<String> test = new ArrayDeque<>();
        test.addLast("a");
        test.addLast("b");
        test.addFirst("c");
        test.addLast("d");
        test.addLast("e");
        test.addFirst("f");
        test.addLast("g");
        test.addLast("h");
        test.addFirst("9");
        test.addFirst("9");
        test.addFirst("9");
        System.out.println("Current list size: " + test.size());
        //test.printDeque();
//        System.out.println(test.removeFirst());
//        System.out.println(test.removeLast());
        System.out.println("----------print----");
        test.printDeque();
        test.addFirst("1232131");
        test.addFirst("1232131");
        test.addFirst("1232131");
        test.addLast("last last last");
        System.out.println("----------get item----------");
        System.out.println(test.get(0));
        System.out.println(test.get(1));
        System.out.println(test.get(2));
        System.out.println(test.get(3));
        System.out.println(test.get(4));
        System.out.println(test.get(5));
        System.out.println(test.get(6));
        System.out.println(test.get(7));
        System.out.println(test.get(8));
        System.out.println(test.get(9));
        System.out.println(test.get(10));
        System.out.println(test.get(11));
        test.removeFirst();
        test.addLast("test2");
        test.removeLast();
        test.printDeque();
        //check if array is expanding correctly
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        test.addFirst("10");
        System.out.println(test.size());
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst(); //will shrink the array here
    }

    @Override
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("There is no item in the list");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    private int indexDecrement(int index) {
        if (index == 0) {
            index = itemsArray.length - 1;
        } else {
            index = index - 1;
        }
        return index;
    }

    private int indexIncrement(int index) {
        if (index == itemsArray.length - 1) {
            index = 0;
        } else {
            index = index + 1;
        }
        return index;
    }

    @Override
    public void addFirst(T item) {
        if (size == itemsArray.length) {
            resize(size * resizeFactor);
        }
        itemsArray[firstIndex] = item;
        firstIndex = indexDecrement(firstIndex);
        size += 1;

    }

    @Override
    public void addLast(T item) {
        if (size == itemsArray.length) {
            resize(size * resizeFactor);
        }
        itemsArray[lastIndex] = item;
        lastIndex = indexIncrement(lastIndex);
        size += 1;

    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int currentFirstItemIndex = indexIncrement(firstIndex);
        T currentFirstItem = itemsArray[currentFirstItemIndex];
        itemsArray[currentFirstItemIndex] = null;
        firstIndex = indexIncrement(firstIndex);
        size -= 1;
        if (getUsage() < shrinkFactor) {
            System.out.println("Using " + getUsage() + " of the array");
            resize(itemsArray.length / 2);
        }
        return currentFirstItem;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int currentLastItemIndex = indexDecrement(lastIndex);
        T currentLastItem = itemsArray[currentLastItemIndex];
        itemsArray[currentLastItemIndex] = null;
        lastIndex = indexDecrement(lastIndex);
        size -= 1;
        if (getUsage() < shrinkFactor) {
            resize(itemsArray.length / 2);
        }
        return currentLastItem;
    }

    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        }
        int currentFirstIndex = indexIncrement(firstIndex);
        int newIndex = (index + currentFirstIndex);
        if (newIndex >= itemsArray.length) {
            newIndex = newIndex - itemsArray.length;
        }
        return itemsArray[newIndex];
    }

    private double getUsage() {
        this.usage = 1.0 * this.size / this.itemsArray.length;
        return this.usage;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
//        copy to new array
        for (int i = 0; i < size; i++) { //this way so new array get sorted out
            newArray[i + newArray.length / 4] = get(i); //put old array in the middle of new array
        }
//        System.arraycopy(itemsArray, 0, newArray, newArray.length / 4, itemsArray.length);

        //point old array to new one
        this.itemsArray = newArray;

        //update the next first and last Index
        firstIndex = newArray.length / 4 - 1;
        lastIndex = indexIncrement(firstIndex + size);

//        firstIndex = firstIndex + newArray.length / 4;
//        lastIndex = lastIndex + newArray.length / 4;

    }
}
