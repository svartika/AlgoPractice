package Strings;


import java.util.LinkedList;
import java.util.Queue;

public class Myatoi {
    public int myAtoi(String s) {
        boolean isPositive = true;
        Queue<Integer> q = new LinkedList<>();
        boolean isBreak = false;
        boolean signAppeared = false;
        boolean digitAppeared = false;
        for (int ind = 0 ; ind < s.length() ; ind++ ) {
            char ch = s.charAt(ind);
            if(ch== ' ') {
                if(digitAppeared||signAppeared) break;
                continue;
            } else if (ch == '+') {
                if(signAppeared || digitAppeared) break;
                isPositive = true;
                signAppeared = true;
            } else if (ch == '-') {
                if(signAppeared||digitAppeared) break;
                isPositive = false;
                signAppeared = true;
            } else if (isDigit(ch)) {
                q.add(Character.getNumericValue(ch));
                digitAppeared = true;
            } else {
                break;
            }
        }

        if(q.isEmpty()) return 0;
        int num=0,k=0;
        int maxValue = Integer.MAX_VALUE/10;
        int minValue = Integer.MIN_VALUE/10;
        while(!q.isEmpty()) {

            if(isPositive ) {
                if(num <= maxValue) {
                    num = num *10;
                    if(Integer.MAX_VALUE-num >= q.peek()) {
                        num+=q.remove();
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else  {
                    return Integer.MAX_VALUE;
                }
            }
            else if(!isPositive) {
                if(num >=minValue) {

                    num = num *10;
                    if(num == 0 || num - Integer.MIN_VALUE >= q.peek()) {
                        num-=q.remove();
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else  {
                    return Integer.MIN_VALUE;
                }

            }
        }
        return num;
    }

    private boolean isDigit(char ch) {
        if(ch>='0' && ch<='9') return true;
        else return false;
    }
    public static void main(String args[]) {
        /*System.out.println(new Myatoi().myAtoi("42"));
        System.out.println(new Myatoi().myAtoi("   -42"));
        System.out.println(new Myatoi().myAtoi("   4193 with words"));
        System.out.println(new Myatoi().myAtoi("words and 987"));
        System.out.println(new Myatoi().myAtoi("-91283472332 is a word"));*/
        //System.out.println(new Myatoi().myAtoi("3.14159"));
        System.out.println(new Myatoi().myAtoi("+1"));
        System.out.println(new Myatoi().myAtoi("00000-42a1234"));
    }
}
