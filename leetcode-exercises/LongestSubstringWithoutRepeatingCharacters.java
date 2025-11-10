public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("" + lengthOfLongestSubstring("dvldf"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int longest = 1;
        String subString = "";
        for (int i = 0; i < s.length(); i++) {

            if (!subString.contains("" + s.charAt(i))) {
                subString = subString.concat("" + s.charAt(i));
            } else {
                subString = "" + s.charAt(i);
            }

            if (subString.length() > longest) {
                longest = subString.length();
            }
        }

        if (subString.length() > longest) {
            longest = subString.length();
        }

        return longest;
    }
}
