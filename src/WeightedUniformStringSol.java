import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeightedUniformStringSol {

    public static void main(String[] args) {
       /* char[] ref = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            // your code goes here
            boolean found = false;
            for (int i = 1; i <= 26; i++) {
                if ((x % i) != 0) {
                    continue;
                }
                Pattern p = Pattern.compile(ref[i - 1] + "{" + (x / i) + "}");
                Matcher m = p.matcher(s);
                if (m.find()) {
                    System.out.println("Yes");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No");
            }
        }*/
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int prevChar = s.charAt(0) - 'a' + 1;
        int count = 1;
        Set<Integer> set = new HashSet<>();
        set.add(count * prevChar);
        for (int i = 1; i < s.length(); i++) {
            int currChar = s.charAt(i) - 'a' + 1;
            if (currChar == prevChar) {
                count++;
            } else {
                prevChar = currChar;
                count = 1;
            }
            set.add(count * currChar);
        }
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++) {
            int x = in.nextInt();
            if (set.contains(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
