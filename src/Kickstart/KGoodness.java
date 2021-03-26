package Kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KGoodness {
    private int findGoodness(String s) {
        int goodness = 0;
        for(int i=0,  j=s.length()-1; i<=Math.ceil(s.length()/2) && j>=Math.floor(s.length()/2);  i++, j--) {
            if(s.charAt(i) != s.charAt(j)) goodness++;
        }
        return goodness;
    }

    public int minOpsForGoodness(String s, int reqGoodness) {
        int goodness = findGoodness(s);
        int minOps = Math.abs(goodness - reqGoodness);
        return minOps;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfTestCases = scanner.nextInt();
        //System.out.println("Num of test cases: " + numOfTestCases );
        KGoodness obj = new KGoodness();
        for(int i=1; i<= numOfTestCases; ++i) {
            int testCaseNum = scanner.nextInt();
           // System.out.println("testCaseNum: " + testCaseNum );
            int reqGoodness = scanner.nextInt();
            //System.out.println("reqGoodness: " + reqGoodness );
            String s = scanner.next();
           // System.out.println("s: " + s );
            int minOps = obj.minOpsForGoodness(s, reqGoodness);
            String output = "Case #" + i + ": " + minOps;
            System.out.println(output);
        }
    }
}
