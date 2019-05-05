public class DLListTest {
    //private IntNode first;
    private int listSize;
    private IntNode sentinel;

    public DLListTest() { //Empty list declaration
        /* basically sentinel is the very first item in the list
        but it'll be not considered by the user using this SLList class
        so sentinel actually acts as a pointer for the very first item
         */
        sentinel = new IntNode(63, null);
        listSize = 0;

    }

    public DLListTest(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        listSize = 1; //for caching the size, so it increase every time new item gets added

    }

    public static void main(String[] args) {
        /* For testing purpose */
        SLList2 Y = new SLList2(1);
        Y.addFirst(3);
        System.out.println(Y.getFirst());
        Y.addLast(6);
        Y.addLast(5);
        Y.addLast(4);
        System.out.println(Y.size());
    }

    /* add an item to the front of the list */
    public void addFirst(int x) {
        /* when adding first
        we are adding the item to the sentinel.next IntNode
         */
        sentinel.next = new IntNode(x, sentinel.next); //sentinel.next becomes second item in the list thats why 2nd parameter
        listSize++;

        /* new x become the first item, and the old list IntNode become the rest of the list */
    }

    /* get the first item in the list */
    public int getFirst() {
        //first's item becomes sentinel.next's item
        return sentinel.next.item;
    }

    /* Add an item to the end of the list */
    public void addLast(int x) {
        listSize++; //caching the size

        //getting to next (IntNode) of the last item in the original list
        IntNode List = sentinel; //use this to access the IntNode in the SSList, IntNode = first.next
        while (List.next != null) { //loop stop when List.next = null meaning reached end item
            List = List.next; //cycle through each IntNode in the SSLIST
        }
        List.next = new IntNode(x, null); //add x to the last IntNode

    }

    /* Return the size of the List */
    public int size() {
        int size = 1; //start at 1 because we start increasing size from the next item in the SSList
        IntNode List = sentinel.next;
        while (List.next != null) {
            size++;
            List = List.next;
        }
        //return size;
        return listSize;
    }

    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode prev;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
            prev = this; //the prev pointer should be this one? WRONG>???
        }
    }
}
