package march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        String b = createCompositeB(B);
        List<String> universalA = new ArrayList<>();
        for(String a: A) {
            if(bExistsIna(a, b))  universalA.add(a);
        }
        return universalA;
    }

    private boolean bExistsIna(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        for(int i=0; i<b.length(); i++) {
            char charInb = b.charAt(i);
            boolean charInbFoundIna = false;

            for(int j=0; j<sb.length(); j++) {
                char charIna = sb.charAt(j);
                if(charInb == charIna) {
                    sb.setCharAt(j, 'F');
                    charInbFoundIna = true;
                    break;
                }
            }
            if(!charInbFoundIna) return false;
        }
        return true;
    }

    private String createCompositeB(String[]B) {
        StringBuilder compositeB = new StringBuilder();
        for(String b: B) {
            StringBuilder currCompositeB = new StringBuilder(compositeB);
            for(int i=0; i<b.length(); i++) {

                char charInb = b.charAt(i);
                boolean charInbFound = false;
                for(int j=0; j<currCompositeB.length(); j++) {
                    char charInCompositeB = currCompositeB.charAt(j);
                    if(charInb==charInCompositeB) {
                        currCompositeB.setCharAt(j, 'F');
                        charInbFound = true;
                        break;
                    }
                }
                if(!charInbFound) compositeB.append(charInb);
            }
        }
        return compositeB.toString();
    }

    /*public List<String> wordSubsets(String[] A, String[] B) {
        List<String> universalA = new ArrayList<>();
        for(String a: A) {
            boolean universal = true;
            for(String b: B) {
                if(!bExistsIna(a, b)) universal = false;
            }
            if(universal) universalA.add(a);
        }
        return universalA;
    }

    private boolean bExistsIna(String a, String b) {

        for(int i=0; i<b.length(); i++) {
            char charInb = b.charAt(i);
            boolean charInbFoundIna = false;
            StringBuilder sb = new StringBuilder(a);
            for(int j=0; j<sb.length(); j++) {
                char charIna = sb.charAt(j);
                if(charInb == charIna) {
                    sb.setCharAt(j, 'F');
                    charInbFoundIna = true;
                    break;
                }
            }
            if(!charInbFoundIna) return false;
        }
        return true;
    }*/

    public static void main(String args[]) {
        /*String[] A = new String[] {"amazon","apple","facebook","google","leetcode"};
        String[] B = new String[] {"ec","oc","ceo"};*/

        String[] A = new String[] {"amazon","apple","facebook","google","leetcode"};
        String[] B = new String[] {"e","oo"};
        List<String> universalAs = new WordSubsets().wordSubsets(A, B);
        System.out.println(Arrays.toString(universalAs.toArray()));
    }
}
