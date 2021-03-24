package February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> arr = new ArrayList<>();
        arr.add(S);
        return makePermutation(S, 0, arr);
    }

    List<String> makePermutation(String s, int pos, List<String> arr) {
        if(pos<s.length()) {
            char c = s.charAt(pos);
            if(isAlphabet(c)) {
                char[] bothCases = getUpperAndLowerCase(c);
                List<String> interim = new ArrayList<>();
                for(String str: arr) {
                    StringBuilder b = new StringBuilder(str);
                    b.setCharAt(pos, bothCases[0]);
                    interim.add(b.toString());
                    b.setCharAt(pos, bothCases[1]);
                    interim.add(b.toString());
                }
                arr = new ArrayList<>();
                for(String str: interim) {
                    arr.add(str);
                }
            }
            return makePermutation(s, pos+1, arr);
        } else
        return arr;
    }

    boolean isAlphabet(char c) {
        if(c>='a' && c<='z' || c>='A' && c<='Z') //Character.isAlphabetic(c))//
            return true;
        else
            return false;
    }

    char[] getUpperAndLowerCase(char c) {
        char[] bothCases = new char[2];
        bothCases[0] = Character.toUpperCase(c);
        bothCases[1] = Character.toLowerCase(c);
        return bothCases;
    }

    public static  void main(String args[]) {
        /*List<String> arr = new LetterCasePermutation().letterCasePermutation("a1b2");
        for (String str: arr)
            System.out.print(str + " ");*/

        List<String> arr1 = new LetterCasePermutation().letterCasePermutation("c");
        for (String str: arr1)
            System.out.print(str + " ");
    }

}
