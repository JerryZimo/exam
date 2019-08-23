import java.util.HashMap;
import java.util.Scanner;

/**
 * MPMPCPMCMDEFEGDEHINHKLIN
 * 9 7 8
 */
public class Code1_SplitStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        if (str == null || str.length() < 1) {
            System.out.println(0);
            return;
        }
        HashMap<Character, Integer> charLastMap = new HashMap<Character, Integer>();
        char curChar;
        for (int i = 0; i < str.length(); i++) {
            curChar = str.charAt(i);
            charLastMap.put(curChar, i);
        }

        int segStart = 0;
        int segEnd = -1;
        StringBuffer sb = new StringBuffer();
        while (segEnd != str.length() - 1) {
            for (int i = 0; i < str.length(); i++) {
                segStart = segEnd + 1;
                curChar = str.charAt(i);
                segEnd = charLastMap.get(curChar);
                while (i < segEnd) {
                    curChar = str.charAt(++i);
                    segEnd = charLastMap.get(curChar) > segEnd ? charLastMap.get(curChar) : segEnd;
                }
                sb.append(" " + (segEnd - segStart + 1));
            }
        }
        System.out.println(sb.toString().substring(1));
    }
}
