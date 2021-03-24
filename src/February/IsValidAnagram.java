package February;

public class IsValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int freqS[] = new int[26];
        int freqT[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            freqS[c1-'a'] = freqS[c1-'a'] + 1 ;
            char c2 = t.charAt(i);
            freqT[c2-'a'] = freqT[c2-'a']+1;
        }
        for(int i=0; i<freqS.length; i++) {
            if(freqS[i]!=freqT[i]) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(new IsValidAnagram().isAnagram("anagram", "nagaram"));
    }
}
