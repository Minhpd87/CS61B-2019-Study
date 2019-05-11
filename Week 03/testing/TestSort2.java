public class TestSort2 {
    public static void TestSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort2.sort(input);

        org.junit.Assert.assertArrayEquals(expected, input);

    }

    public static void testSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort2.findSmallest(input, 0);

        org.junit.Assert.assertEquals(expected, actual);
    }

    public static void testSwap() {
        String input[] = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String expected[] = {"an", "have", "i", "egg"};

        Sort2.swap(input, a, b);
        org.junit.Assert.assertArrayEquals(expected, input);
    }

    public static void main(String[] args) {
        TestSort();
//        testSmallest();
//        testSwap();
    }
}
