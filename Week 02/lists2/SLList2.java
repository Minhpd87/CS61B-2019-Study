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

    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
}
