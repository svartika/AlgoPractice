package Strings;

public class ReverseInteger {
    public int reverse(int x) {
        int newNum=0;
        int i = -1; int sizeCheck = x;
        while(sizeCheck!=0) {
            sizeCheck = sizeCheck/10;
            i++;
        }
        while(x!=0 && newNum/*+x/10*/!= Integer.MAX_VALUE && newNum/*+x/10*/!=Integer.MIN_VALUE ) {
         //   System.out.println(String.format("%d %d %d",newNum, x, newNum+x/10));
            int rem = x%10;
            x = x/10;
            newNum += rem*Math.pow(10,i);
            i--;
        }
        if(newNum==Integer.MAX_VALUE || newNum==Integer.MIN_VALUE) return 0;
        return newNum;
    }
    public static void main(String args[]) {
        System.out.println(new ReverseInteger().reverse(123));
        System.out.println(new ReverseInteger().reverse(-123));
        System.out.println(new ReverseInteger().reverse(120));
        System.out.println(new ReverseInteger().reverse(0));
        System.out.println(new ReverseInteger().reverse(1534236469));
    }
}
