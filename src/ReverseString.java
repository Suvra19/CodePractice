import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(reverseString(str));
    }

    private static String reverseString(String str) {
        System.out.println(str);
        if ((str == null) || (str.length() <= 1)) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
