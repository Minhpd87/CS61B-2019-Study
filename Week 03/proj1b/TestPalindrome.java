import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalindrome() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("dat"));
        assertFalse(palindrome.isPalindrome("mama"));
        assertFalse(palindrome.isPalindrome("xdddd"));
    }

    @Test
    public void testPaldindromeByN() {
        CharacterComparator offbyN = new OffByN(1);
        assertTrue(palindrome.isPalindrome("flake", offbyN));

    }
}
//     Uncomment this class once you've created your Palindrome class. */