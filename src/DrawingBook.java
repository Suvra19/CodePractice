import java.util.Scanner;

public class DrawingBook {

    static int findMinPageTurne(int startPage, int endPage, int page, int maxPageTurns) {
        int midPage = (startPage + endPage) / 2;
        if (midPage == page) {
            return Math.min(midPage / 2, maxPageTurns - (midPage / 2));
        }
        if (page < midPage) {
            endPage = midPage;
        } else {
            startPage = midPage;
        }
        return findMinPageTurne(startPage, endPage, page, maxPageTurns);
    }

    static int solve(int n, int p){
        if (p == 1 || p == n) {
            return 0;
        }
        return findMinPageTurne(1, n, p, n / 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
