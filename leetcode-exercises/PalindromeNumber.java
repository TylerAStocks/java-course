


public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }


    public static boolean isPalindrome(int x) {

        String asString = Integer.toString(x);

        for (int i = asString.length() - 1; i >= 0; i--) {
            if (asString.charAt(i) - '0' != asString.charAt(asString.length() - 1 - i) - '0') {
                return false;
            }
        }

        return true;
    }
}
