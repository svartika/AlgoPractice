package Strings;

public class ValidPalindrome {
    public boolean isPalindrome1(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length/2; i++) {
            if(arr[i]!=arr[arr.length-1-i]) return false;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        while(start<end) {
            start = moveTillYouFindValidChar(s, start, true);
            end = moveTillYouFindValidChar(s, end, false);
            System.out.println(String.format("start %d[%c] end %d[%c] ", start,s.charAt(start), end, s.charAt(end)));
            if(start!=-1 && end!=-1 && start < end) {
                if(s.charAt(start) == s.charAt(end)) {
                    start = start + 1;
                    end = end - 1;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public int moveTillYouFindValidChar(String s, int start, boolean goRight) {
        int index = start;
        while (index < s.length() && index>=0) {
            char c = s.charAt(index);
            if((c>= 'a' && c <= 'z') || (c>='A' && c <= 'Z') || (c>='0' && c<='9')) {
                return index;
            }
            index = goRight?index+1:index-1;
        }
        return -1;
    }

    public static void main(String args[]) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
    }
}
