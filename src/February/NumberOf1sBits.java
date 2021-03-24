package February;

public class NumberOf1sBits {
    public int hammingWeight(int n) {
        /*int cntOne = 0;
        while(n>0) {
            if(n%2==1) cntOne++;
            n=n/2;
        }
        return cntOne;*/

        int cntOne = 0;
        for(int i=0; i<32; i++) {
            int num = n>>i;
            int is1 = num & i;
            cntOne += (n>>i & 1) == 1 ? 1 : 0 ;
        }
        return cntOne;
    }

    public static void main(String[] args) {
        int n = 01011;
        System.out.println(new NumberOf1sBits().hammingWeight(n));

        //int n1 = 00000000000000000000000010000000;
       // System.out.println(new NumberOf1sBits().hammingWeight(n1));

        int n2 = 0b11111111111111111111111111111101 ;
        System.out.println(new NumberOf1sBits().hammingWeight(n2));

    }
}
