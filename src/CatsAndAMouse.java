import java.util.Scanner;

public class CatsAndAMouse {
    static String[] catAndMouse(int x, int y, int z) {
        // Complete this function
        String[] result = new String[2];
        int xtoz = Math.abs(x - z);
        int ytoz = Math.abs(y - z);
        if (ytoz == xtoz) {
            result[0] = "Mouse";
            result[1] = "C";
        } else {
            int min = Math.min(xtoz, ytoz);
            if (min == xtoz) {
                result[0] = "Cat";
                result[1] = "A";
            } else {
                result[0] = "Cat";
                result[1] = "B";
            }
        }
        return result;
    }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int q = in.nextInt();
            for(int a0 = 0; a0 < q; a0++){
                int x = in.nextInt();
                int y = in.nextInt();
                int z = in.nextInt();
                String[] result = catAndMouse(x, y, z);
                for (int i = 0; i < result.length; i++) {
                    System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
                }
                System.out.println("");


            }
            in.close();
        }
    }
