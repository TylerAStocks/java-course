
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }


    public static int romanToInt(String s) {

        int value = 0;
        for (int i = 0; i < s.length(); i++) {


            switch (s.charAt(i)) {
                case 'I':
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'V' ) {
                            value += 4;
                            break;
                        } else if (s.charAt(i + 1) == 'X') {
                            value += 9;
                            break;
                        } 
                    }
                    value += 1;
                    break;

                case 'V':
                    if (i > 0 && s.charAt(i - 1) == 'I') {
                        break;
                    }
                    value += 5;
                    break;

                case 'X':
                    if (i > 0 && s.charAt(i - 1) == 'I') {
                        break;
                    }
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'L' ) {
                            value += 40;
                            break;
                        } else if (s.charAt(i + 1) == 'C') {
                            value += 90;
                            break;
                        } 
                    }
                    value += 10;
                    break;

                case 'L':
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        break;
                    }
                    value += 50;
                    break;    



                case 'C':
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        break;
                    }
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'D' ) {
                            value += 400;
                            break;
                        } else if (s.charAt(i + 1) == 'M') {
                            value += 900;
                            break;
                        } 
                    }
                    value += 100;
                    break;

                case 'D':
                    if (i > 0 && s.charAt(i - 1) == 'C') {
                        break;
                    }
                    value += 500;
                    break; 

                case 'M':
                    if (i > 0 && s.charAt(i - 1) == 'C') {
                        break;
                    }
                    value += 1000;
                    break; 
            }

        }

        return value;
    }
}
