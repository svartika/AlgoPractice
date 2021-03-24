package Strings;

import java.util.LinkedList;
import java.util.Queue;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1) return "1";
        else {
            String str = countAndSay(n - 1);
            Queue q = getCountAndNumber(str);
            StringBuilder builder = new StringBuilder();
            while(!q.isEmpty()) {
                builder.append(q.remove());
            }
            return builder.toString();
        }
    }
    private Queue getCountAndNumber(String str) {
        Queue q = new LinkedList();
        int start = Character.getNumericValue(str.charAt(0));
        int count = 1;
        for(int i=1; i<str.length(); i++) {
            char ch = str.charAt(i);
            int i1 = Character.getNumericValue(ch);
            if (start==i1) count++;
            else {
                q.add(count);
                q.add(start);
                count=1;
                start=i1;
            }
        }
        q.add(count);
        q.add(start);
        return q;
    }

    public static void main(String args[]) {
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
        System.out.println(new CountAndSay().countAndSay(6));
        System.out.println(new CountAndSay().countAndSay(7));
    }
}
