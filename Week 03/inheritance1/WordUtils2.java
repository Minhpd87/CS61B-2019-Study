public class WordUtils2 {
    public static String longest(List61B<String> stringList) {
        String longest = stringList.get(0);
        for (int i = 1; i < stringList.size(); i++) {
            if (longest.length() < stringList.get(i).length()) {
                longest = stringList.get(i);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        SLList<String> someList = new SLList<>();
        someList.addLast("elk");
        someList.addLast("are");
        someList.addLast("watching");
        System.out.println(longest(someList));
    }
}
