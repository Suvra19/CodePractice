import java.util.Scanner;

public class CaesarCipherSol {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int strSize = in.nextInt();
        String str = in.next();
        int key = in.nextInt();
        String result = "";
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result += (char) ('a' + ((c - 'a' + key) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                result += (char) ('A' + ((c - 'A' + key) % 26));
            } else {
                result += c;
            }
        }
        System.out.println(result);
    }
}
