public class RotatingSLList<T> extends SLList<T> {

    public static void main(String[] args) {
        RotatingSLList<Integer> test = new RotatingSLList<>();
        test.addLast(5);
        test.addLast(9);
        test.addLast(15);
        test.addLast(22);

        test.rotateRight();
        test.print();
    }

    public void rotateRight() {
        /** which takes in an existing list, and rotates every element one spot to the right,
         * moving the last item to the front of the list. */

        T lastItem = this.removeLast();
        this.addFirst(lastItem);
    }
}
