package Strings;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freqS = new int[26];
        int freqT[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            int j = chS;
            freqS[j - 97] = freqS[j - 97] + 1;
            char chT = t.charAt(i);
            j = chT;
            freqT[j - 97] = freqT[j - 97] + 1;
        }
        for (int i = 0; i < freqS.length; i++) {
            if (freqS[i] != freqT[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(new IsAnagram().isAnagram("hello", "llheo"));
        System.out.println(new IsAnagram().isAnagram("anagram", "nagaram"));
        System.out.println(new IsAnagram().isAnagram("a", "nagaram"));
        System.out.println(new IsAnagram().isAnagram("anagran", "nagaram"));
    }
}
