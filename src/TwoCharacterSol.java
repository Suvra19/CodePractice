import java.util.*;
import java.util.stream.Collectors;

/*
* 121
txnbvnzdvasknhlmcpkbxdvofimsvqbvkswlkrchohwuplfujvlwpxtlcixpajjpaskrnjneelqdbxtiyeianqjqaikbukpicrwpnjvfpzolcredzmfaznnzd
* */

public class TwoCharacterSol {

    /*public static int longestAltString(String s) {
        char [][] letters = new char[26][26];
        int [][] values = new int[26][26];
        for(char c : s.toCharArray()) {
            int index = (int)(c - 'a');
            for(int i = 0; i < 26; i++) {
                if(letters[index][i] != c && values[index][i] != -1) {
                    letters[index][i] = c;
                    ++values[index][i];
                } else {
                    values[index][i] = -1;
                }
                if(letters[i][index] != c && values[i][index] != -1) {
                    letters[i][index] = c;
                    ++values[i][index];
                } else {
                    values[i][index] = -1;
                }
            }
        }
        int largestString = 0;
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                if(values[i][j] > largestString) {
                    largestString = values[i][j];
                }
            }
        }
        if(largestString > 1) {
            return largestString;
        } else {
            return 0;
        }
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        List<Character> trackerList = s.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        stripOffRepeatingChars(trackerList);
        System.out.println("Step-1 " + trackerList.size());
        if (trackerList.size() > 2) {
            trackerList.removeAll(allSoloChars(trackerList));
            System.out.println("Step-2 " + trackerList.size());
            if (trackerList.size() > 2) {
                System.out.println("Step-3 " + trackerList.size());
                if (verifyCharAlternation(trackerList)) {
                    System.out.println(trackerList.size());
                } else {
                    System.out.println(0);
                }
            } else {
                System.out.println(trackerList.size() == 2 ? 2 : 0);
            }
        } else {
            System.out.println(trackerList.size() == 2 ? 2 : 0);
        }

    }

    private static boolean verifyCharAlternation(List<Character> trackerList) {
        System.out.println();
        for (Character c : trackerList) {
            System.out.print(c + " ");
        }
        for (int i = 0, j = 2; i < trackerList.size() && j < trackerList.size(); i++, j++) {
            if (!(trackerList.get(j) == trackerList.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Set<Character> allSoloChars(List<Character> trackerList) {
        Set<Character> masterSet = new HashSet<>();
        List<Character> repeatingSet = new ArrayList<>();
        for (int  i = 0; i < trackerList.size(); i++) {
            if (!masterSet.add(trackerList.get(i))) {
               repeatingSet.add(trackerList.get(i));
            }
        }
        masterSet.removeAll(repeatingSet);
        return masterSet;
    }

    private static void stripOffRepeatingChars(List<Character> trackerList) {
        Character prevChar = trackerList.get(0);
        List<Character> chars = new ArrayList<>();
        for (int i = 1; i < trackerList.size(); i++) {
            Character currentChar = trackerList.get(i);
            if (currentChar == prevChar) {
                chars.add(currentChar);
                trackerList.removeAll(chars);
                chars.clear();
                i = -1;
            } else {
                prevChar = currentChar;
            }
        }
    }
}
