public class SLList2 {
    private IntNode first;

    public SLList2(int x) {
        first = new IntNode(x, null);
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
        first = new IntNode(x, first);
        /* new x become the first item, and the old list IntNode become the rest of the list */
    }

    /* get the first item in the list */
    public int getFirst() {
        return first.item;
    }

    /* Add an item to the end of the list */
    public void addLast(int x) {
        //getting to next (IntNode) of the last item in the original list
        IntNode List = first; //use this to access the IntNode in the SSList, IntNode = first.next
        while (List.next != null) { //loop stop when List.next = null meaning reached end item
            List = List.next; //cycle through each IntNode in the SSLIST
        }
        List.next = new IntNode(x, null); //add x to the last IntNode
    }

    /* Return the size of the List */
    public int size() {
        int size = 1; //start at 1 because we start increasing size from the next item in the SSList
        IntNode List = first;
        while (List.next != null) {
            size++;
            List = List.next;
        }
        return size;
    }

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
}
