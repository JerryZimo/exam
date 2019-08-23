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
        // 记录每个字符在str中最后出现的位置
        HashMap<Character, Integer> charLastMap = new HashMap<Character, Integer>();
        char curChar;
        for (int i = 0; i < str.length(); i++) {
            curChar = str.charAt(i);
            charLastMap.put(curChar, i);
        }

        // 按照逻辑，分段过程是，每次观察到str的i位置的字符curChar，就需要观察到curChar字符组后出现的位置，
        // 那么这之间的部分，必须是同一个段内，然后继续遍历观察，发现新的字符，这时候对于段尾，可能发生变化，即：
        // segEnd = charLastMap.get(curChar) > segEnd ? charLastMap.get(curChar) : segEnd;
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
