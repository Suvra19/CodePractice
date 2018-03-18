import java.util.Scanner;

public class HackerrankStringSol {
    private static final String refString = "hackerrank";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        char[] checkStr = refString.toCharArray();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // your code goes here
            int j = 0;
            for (int i = 0; i < s.length() && j < checkStr.length; i++) {
                if (s.charAt(i) == checkStr[j]) {
                    j++;
                }
            }
            if (j == checkStr.length) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
