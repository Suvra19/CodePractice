import java.util.Scanner;

public class CodeCompetition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String winnerName = "";
        int winningScore = -1;
        for (int a0 = 0; a0 < n; a0++) {
            String name = in.next();
            int d = in.nextInt();
            int j = in.nextInt();
            if ((j - d) > winningScore) {
                winnerName = name;
                winningScore = j - d;
            }
        }
        System.out.println(winnerName + " " + winningScore);
        in.close();
    }
}

