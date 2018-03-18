import java.util.Scanner;

public class AcidNaming {

    static String acidNaming(String acid_name) {
        // Complete this function
        String result;
        if(acid_name.endsWith("ic")) {
            if (acid_name.startsWith("hydro")) {
                result = "non-metal acid";
            } else {
                result = "polyatomic acid";
            }
        } else {
            result = "not an acid";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String acid_name = in.next();
            String result = acidNaming(acid_name);
            System.out.println(result);
        }
        in.close();
    }
}
