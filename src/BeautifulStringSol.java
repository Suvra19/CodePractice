import java.util.Scanner;

public class BeautifulStringSol {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        boolean isBeautiful = true;
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int aSize = 1;
            int bSize = 1;
            for (int i = 1; i < s.length() - 1; i++) {
                int b = Integer.parseInt(s.substring(i, i + bSize));
                int a = Integer.parseInt(s.substring(i - aSize, i));
                System.out.println(b + " - " + a);
                if (b - a == 1) {
                    aSize = bSize = 1;
                } else {
                    bSize++;
                    if (i + 2 <= s.length()) {
                        b = Integer.parseInt(s.substring(i, i + 2));
                        System.out.println(b + " - " + a);
                        if (b - a != 1 && i + 3 <= s.length()) {
                            b = Integer.parseInt(s.substring(i + 1, i + 3));
                            a = Integer.parseInt(s.substring(i - 1, i + 1));
                            System.out.println(b + " - " + a);
                            if (b - a != 1 && i + 4 <= s.length()) {
                                aSize = 2;
                                b = Integer.parseInt(s.substring(i + 1, i + 4));
                                System.out.println(b + " - " + a);
                                if (b - a != 1) {
                                    isBeautiful = false;
                                }
                            }
                        }
                    }
                }

            }
            if (isBeautiful) {
                System.out.println("YES " + s.substring(0, aSize));
            } else {
                System.out.println("NO");
            }

        }
    }
}
