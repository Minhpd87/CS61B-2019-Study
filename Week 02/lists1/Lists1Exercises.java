public class Lists1Exercises {
    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change.
     */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        IntList newList = null;
        for (int i = L.size() - 1; i > -1; i--) { //construct the newList backwardly, iteratively
            newList = new IntList(L.get(i) + x, newList);
        }
        return newList;
    }

    public static IntList incrListR(IntList L, int x) {
        /* Your code here. */
        if (L == null) {
            return null;
        }
        //each recursive run will create a new IntList until L.rest.rest.rest... = null meaning reaching the last item in
        //the original list
        return new IntList(L.first + x, incrListR(L.rest, x));
    }

    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword.
     */
    public static IntList dincrList(IntList L, int x) { //iteratively
        /* Your code here. */
        IntList p = L;
        while (p != null) {
            p.first = p.first + x; //this mutate the L.first since p.first and l.first are the same
            p = p.rest; //until p = null then it point to another list
        }
        return L; //not p because P is null at this point and it point to the rest not the original list
    }

    public static IntList dincrListR(IntList L, int x) { //recursively
        if (L == null) {
            return null;
        }
        L.first = L.first + x; //mutate L.first
        dincrListR(L.rest, x); //mutate the next L.rest.first
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);
        System.out.println("List size: ");
        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        System.out.println("L list: ");
        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));
        IntList X = incrListR(L, 3);

        System.out.println("------------");
        System.out.println(X.get(0));
        System.out.println(X.get(1));
        System.out.println(X.get(2));

        IntList Y = dincrListR(L, 3);
        System.out.println("------------");
        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));

        IntList Z = square(L);
        System.out.println(Z.get(0));
        System.out.println(Z.get(1));
        System.out.println(Z.get(2));
    }

    public static IntList square(IntList L) {
//        if (L == null) {
//            return L;
//        } else {
//            IntList rest = square(L.rest);
//            IntList M = new IntList(L.first * L.first, rest);
//            return M;
//        }

        //iteratively
        IntList p = L;
        IntList result = new IntList(L.first * L.first, null);
        IntList p2 = result;
        p = p.rest;

        while (p != null) {
            p2.rest = new IntList(p.first * p.first, null);
            p = p.rest;
            p2 = p2.rest;
        }
        return result;

    }

    public static IntList squareDestructive(IntList L) {
        IntList p = L;
        while (p != null) {
            p.first = p.first * p.first;
            p = p.rest;
        }
        return L;

        //recursively
//        if (L == null) {
//            return L;
//        } else {
//            L.first *= L.first; //this change the first item in L
//            squareDestructive(L.rest); //do the next item
//        }
    }
}