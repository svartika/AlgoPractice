package January;

import java.util.Arrays;

public class SmallestStringWithGivenNumericValur {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        for(int i=n-1; i>=0; i--) {
            int val = Math.min(26, k-i);
            res[i] += val-1;
            k = k-val;
        }
        return String.valueOf(res);
    }

   /* public String getSmallestString(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=n-1; i>=0; i--) {
            int val = Math.min(26, k-i);
            char ch = convertValToLowerCaseChar(val);
            stringBuilder.insert(0, ch);
            k = k-val;
        }
        return stringBuilder.toString();
    }*/
    char convertValToLowerCaseChar(int val) {
        switch(val) {
            case 1:
                return 'a';
            case 2:
                return 'b';
            case 3:
                return 'c';
            case 4:
                return 'd';
            case 5:
                return 'e';
            case 6:
                return 'f';
            case 7:
                return 'g';
            case 8:
                return 'h';
            case 9:
                return 'i';
            case 10:
                return 'j';
            case 11:
                return 'k';
            case 12:
                return 'l';
            case 13:
                return 'm';
            case 14:
                return 'n';
            case 15:
                return 'o';
            case 16:
                return 'p';
            case 17:
                return 'q';
            case 18:
                return 'r';
            case 19:
                return 's';
            case 20:
                return 't';
            case 21:
                return 'u';
            case 22:
                return 'v';
            case 23:
                return 'w';
            case 24:
                return 'x';
            case 25:
                return 'y';
            case 26:
                return 'z';
        }
        return 'z';
    }

    public static void main(String arg[]) {
        System.out.println(new SmallestStringWithGivenNumericValur().getSmallestString(3, 27));
        System.out.println(new SmallestStringWithGivenNumericValur().getSmallestString(5, 73));
    }
}
