public class LinkedListDeque<T> implements Deque<T> {

    private IntNode sentinel;
    private int size;


    public LinkedListDeque() {
        //An empty list has no previous and next node = null
        sentinel = new IntNode(null, (T) "??", null);
        //point the previous and next node to itself so it makes a circle
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        this();
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> test = new LinkedListDeque<Integer>();

        test.addLast(4);
        test.addLast(5);
        test.addFirst(3);
        test.addFirst(2);
        //System.out.println(test.removeFirst());
        test.addLast(6);
        //System.out.println(test.removeLast());
        System.out.println(test.get(0));
        System.out.println(test.get(1));
        System.out.println(test.get(2));
        System.out.println(test.get(3));
        System.out.println(test.get(4));
        System.out.println(test.get(99));
        System.out.println("-----------");
        test.printDeque();
        System.out.println("--Get recursive--");
        System.out.println(test.getRecursive(0));
        System.out.println(test.getRecursive(1));
        System.out.println(test.getRecursive(2));
        System.out.println(test.getRecursive(3));
        System.out.println(test.getRecursive(4));

        LinkedListDeque<Integer> test2 = new LinkedListDeque<>(test);
        test2.printDeque();

    }

    public void addFirst(T item) {
        size += 1;
        IntNode newFirstItem = new IntNode(sentinel, item, sentinel.next);
        if (isEmpty()) {
            //list is empty, last pointer point to first item
            sentinel.prev = newFirstItem;
        } else {
            //list is not empty, the old first item's previous node must point to this new first item
            sentinel.next.prev = newFirstItem;
        }
        //put the new first item in place
        sentinel.next = newFirstItem;
    }

    public void addLast(T item) {
        size += 1;
        IntNode newLastItem = new IntNode(sentinel.prev, item, sentinel);
        if (isEmpty()) {
            //list is empty, the first item must be this newLastItem
            sentinel.next = newLastItem;
        } else {
            //list is not empty, the current last item's next node must point to the new last item
            sentinel.prev.next = newLastItem;
        }
        //put the new last item in place
        sentinel.prev = newLastItem;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode currentItem = sentinel.next;
        while (currentItem != sentinel) {
            System.out.print(currentItem.item + " ");
            currentItem = currentItem.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (!isEmpty()) {
            size -= 1;
            IntNode secondItem = sentinel.next.next; //in case there is one item, this point back to sentinel so it's all good
            secondItem.prev = sentinel; //point this to sentinel as the first item is removed
            T result = sentinel.next.item; //the item that is going to be removed
            sentinel.next = secondItem; //point this to second item making it the new first item, GC will clean up the old first item
            return result;
        }
        return null;
    }

    public T removeLast() {
        if (!isEmpty()) {
            size -= 1;
            IntNode secondToLastItem = sentinel.prev.prev; //get the second to last item, if there is only one item, this points to sentinel
            secondToLastItem.next = sentinel; //point this to sentinel as the last item is removed
            T result = sentinel.prev.item;
            sentinel.prev = secondToLastItem; //last pointer changed to this
            return result;
        }
        return null;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        IntNode currentItem = sentinel.next;
        while (index > 0) {
            currentItem = currentItem.next;
            index -= 1;
        }
        return currentItem.item;
    }

    public T getRecursive(int index) {
        //no idea just yet
        return null;
    }

    public class IntNode {
        private IntNode prev;
        private T item;
        private IntNode next;

        public IntNode(IntNode p, T item, IntNode n) {
            prev = p;
            this.item = item;
            next = n;
        }
    }

}