package Strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefix = strs[0];
        if(prefix.isEmpty()) return "";
        for(int i=1; i< strs.length; i++) {
            prefix = findCommonPrefix(prefix, strs[i]);
            if(prefix.isEmpty()) return "";
        }
        return prefix;
    }
    private String findCommonPrefix(String s1, String s2) {
        if(s1.isEmpty() || s2.isEmpty()) return "";
        StringBuilder sbPrefix = new StringBuilder("");
        int len = Math.min(s1.length(), s2.length());
        for(int i=0; i<len; i++) {
            if(s1.charAt(i)==s2.charAt(i)) sbPrefix.append(s1.charAt(i));
            else return sbPrefix.toString();
        }
        return sbPrefix.toString();
    }

    public static void main(String[] args) {
        //String[] strs = new String[] {"flower", "flow", "flight"};
        String[] strs = new String[] {"dog", "racecar", "car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
