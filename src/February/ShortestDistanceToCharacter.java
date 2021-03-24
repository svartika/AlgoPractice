package February;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToCharacter {
    private List<Integer> findCharIndices(String s, char c) {
        List<Integer> charIndices = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            char currChar = s.charAt(i);
            if(c==currChar) charIndices.add(i);
        }
        return charIndices;
    }
    private int indexOfFirstCharIndexMoreThanChar(int i, List<Integer> charIndices) {
        int index = 0;
        while(index <charIndices.size() && i > charIndices.get(index) ) {
            index++;
        }
        if(index==charIndices.size()) {
            return -1;
        } else {
            return index;
        }
    }
    private boolean allEsAreRightOfChar(int start) {
        return start ==0;
    }
    private boolean allEsAreLeftOfChar(int start) {
        return start == -1;
    }
    private int findDistanceOfNearestIndexOfC(int i, List<Integer> charIndices) {
        if(charIndices.contains(i)) return 0;
        int start = indexOfFirstCharIndexMoreThanChar(i, charIndices);

        if(allEsAreRightOfChar(start)) {
            return charIndices.get(0)-i;
        } else if(allEsAreLeftOfChar(start)) {
            return i-charIndices.get(charIndices.size()-1);
        } else {
            return Math.min(Math.abs(charIndices.get(start)-i), Math.abs(i-charIndices.get(start-1)));
        }
    }
    public int[] shortestToChar(String s, char c) {
        int[] distanceArray = new int[s.length()];
        List<Integer> charIndices = findCharIndices(s, c);
        for(int i=0; i<s.length(); i++) {
            int d = findDistanceOfNearestIndexOfC(i, charIndices);
            distanceArray[i] = d;
        }
        return distanceArray;
    }

    public static void main(String args[]) {
        /*String s = "loveleetcode";
        char c = 'e';*/

        String s = "aababaaabaab";
        char c = 'b';
        int[] distanceArray = new ShortestDistanceToCharacter().shortestToChar(s, c);
        for(int i : distanceArray) System.out.print(i + " ");
    }
}
