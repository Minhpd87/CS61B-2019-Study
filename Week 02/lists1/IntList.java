public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.print("Iterative size method: ");
        System.out.println(L.iterativeSize());
        System.out.print("Recursive size method: ");
        System.out.println(L.size());
        System.out.println("Recursive get: ");
        System.out.println("First item: " + L.get(0));
        System.out.println("Second item: " + L.get(1));
        System.out.println("Third item: " + L.get(2));
        System.out.println("Iterative get: ");
        System.out.println("First item: " + L.iterativeGet(0));
        System.out.println("Second item: " + L.iterativeGet(1));
        System.out.println("Third item: " + L.iterativeGet(2));
    }

    /**
     * Return the size of the list using... recursion!
     */
    public int size() {
        //the base case
        if (rest == null) {
            return 1; //when IntList rest = null, there is only one first Item
        } else {
            return 1 + this.rest.size(); //If rest is not null then we have more item, so return current item (1)
            // plus the IntList rest size
        }
    }

    /**
     * Return the size of the list using no recursion!
     */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest; //move to the next IntList
        }
        return totalSize;
    }

    /**
     * Returns the ith value in this list.
     */
    public int get(int i) {
        if (i == 0) { //this always start at index 0
            return this.first; //base case the first item value is first
        }
        return this.rest.get(i - 1); //recursive run, movee on to the next intList
    }

    public int iterativeGet(int i) {
        IntList p = this;
        int index = 0;
        int result = 0;
        while (index <= i) {
            result = p.first; //result always the item in the IntList which is first
            p = p.rest; //if reach this line, meaning we are not the the required i yet, so we moved to the next intList
            index++;
        }
        return result;
    }
} 