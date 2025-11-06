

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flowght"};
        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {

        String prefix = "";

        for (int i = 0; i < strs[0].length(); i++) {

            for (int j = 1; j < strs.length; j ++) {
                if ( strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return prefix;
                }
            }

            prefix = prefix.concat("" + strs[0].charAt(i));
            
        }

        return prefix;

    }
    
}
