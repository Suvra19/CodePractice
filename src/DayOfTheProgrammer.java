import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DayOfTheProgrammer {
    static String solve(int year){
        // Complete this function
        if( year == 1918 ) return "26.09.1918";
        if( isLeapYear( year ) ) return "12.09." + Integer.toString( year );
        else return "13.09." + Integer.toString( year );

    }

    private static boolean isLeapYear(int year) {
        if( year % 4 != 0 ) return false;
        if( year > 1918 && year % 100 == 0 && year % 400 != 0 ) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
