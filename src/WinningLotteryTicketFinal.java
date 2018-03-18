import java.util.Arrays;
import java.util.Scanner;

public class WinningLotteryTicketFinal {

    static long winningLotteryTicket(String[] tickets) {
       /* char[] digits = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (tickets[i].) {

                }
            }
        }*/
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] tickets = new String[n];
        for(int tickets_i = 0; tickets_i < n; tickets_i++){
            String rawId = in.next();
            tickets[tickets_i] = rawId;
        }
        long result = winningLotteryTicket(tickets);
        System.out.println(result);
        in.close();
    }
}
