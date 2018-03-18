import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PangramsProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().toLowerCase();
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                charSet.add(s.charAt(i));
            }
        }
        if (charSet.size() == 26) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }



}
