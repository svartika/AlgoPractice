package Strings;

public class MyStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(haystack.isEmpty()) return -1;
        if(needle.length() > haystack.length()) return -1;

        for(int i=0; i<=haystack.length()-needle.length(); i++) {
            int k=i, j=0;
            boolean found = true;
            while(j<needle.length()) {
                if(haystack.charAt(k)==needle.charAt(j)) {
                    k++;j++;
                } else {
                    found = false;
                    break;
                }
            }
            if(found==true) return i;
        }
        return -1;
    }

    public static void main(String args[]) {
        System.out.println(new MyStrStr().strStr("hell", "ll"));
        System.out.println(new MyStrStr().strStr("hello", "ll"));
       System.out.println(new MyStrStr().strStr("aaaaa", "bba"));
        System.out.println(new MyStrStr().strStr("", ""));
        System.out.println(new MyStrStr().strStr("substring", "substring1"));
        System.out.println(new MyStrStr().strStr("", "a"));
    }
}
