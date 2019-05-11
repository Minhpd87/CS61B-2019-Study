public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> charList = wordToDeque(word);
        //base case
        if (charList.size() == 0 || charList.size() == 1) {
            return true;
        } else if (cc.equalChars(charList.removeFirst(), charList.removeLast())) { //recursive run
            return isPalindrome(dequeToWord(charList), cc);
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        //a word isPalindrome is it read the same backwards
        Deque<Character> charList = wordToDeque(word);
        //base case
        if (charList.size() == 0 || charList.size() == 1) {
            return true;
        } else if (charList.removeFirst() == charList.removeLast()) { //recursive run
            return isPalindrome(dequeToWord(charList));
        }
        return false;
    }

    /* Helper method */
    private String dequeToWord(Deque<Character> charList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charList.size(); i++) {
            sb.append(charList.get(i));
        }
        return sb.toString();
    }
}
