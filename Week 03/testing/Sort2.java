public class Sort2 {

    public static void sort(String[] input) {
        sort(input, 0);
    }

    public static void sort(String[] input, int start) {
        //find the smallest item
        //move it to the front
        //selection sort the rest (using recursion)

        if (start == input.length) {
            return;
        }
        int smallestIndex = findSmallest(input, start);
        swap(input, start, smallestIndex);
        sort(input, start + 1);
    }

    public static int findSmallest(String[] input, int start) {
        int index = start;
        for (int i = start; i < input.length; i++) {
            int cmp = input[i].compareTo(input[index]);
            if (cmp < 0) {
                index = i;
            }
        }
        return index;
    }

    public static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
