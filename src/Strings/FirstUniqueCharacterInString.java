package Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FirstUniqueCharacterInString {
    /*public int firstUniqChar(String s) {
        int uniqueIndex = 0;
        Queue<Character> q = new LinkedList<>();
        char prevCharRemoved=' ';
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!q.isEmpty() && ch==q.peek()) {
                q.remove();
                prevCharRemoved = ch;
                uniqueIndex=i;
            } else {
                if(q.isEmpty() && ch==prevCharRemoved) {
                    uniqueIndex++;
                } else {
                    q.add(ch);
                }
            }
        }
        if(uniqueIndex>=s.length()) return -1;
        else return uniqueIndex;
    }*/

    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            if(hm.containsKey(ch)) {
                int val = hm.get(ch)+1;
                hm.put(ch, val);
            } else {
                hm.put(ch, 1);
            }
        }
        for(int i=0; i<s.length(); i++) {
            if (hm.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
    public static void main(String args[]) {
        System.out.println(new FirstUniqueCharacterInString().firstUniqChar(new String("loveleetcode")));
        System.out.println(new FirstUniqueCharacterInString().firstUniqChar(new String("lll")));
       System.out.println(new FirstUniqueCharacterInString().firstUniqChar(new String("llll")));
        System.out.println(new FirstUniqueCharacterInString().firstUniqChar(new String("lovel")));
        System.out.println(new FirstUniqueCharacterInString().firstUniqChar(new String("love")));
        System.out.println(new FirstUniqueCharacterInString().firstUniqChar(new String("lovol")));
    }
}
