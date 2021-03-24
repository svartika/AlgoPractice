package January;

public class ConcatenateConsecutiveBinaryNumbers {
    /*public int concatenatedBinary(int n) {
        StringBuilder binRep = new StringBuilder();
        for(int i=1; i<=n; i++) {
            //binRep.append(convertToBinary(i));
            binRep.append(Integer.toBinaryString(i));
        }
        int dec = convertToDecimal(binRep.toString());
       // int ret = (int) (dec % (Math.pow(10,9)+7));
        return dec;
    }

    String convertToBinary(int i) {
        int q = i;
        StringBuilder rem = new StringBuilder();
        while(q!=0) {
            rem.insert(0,q%2);
            q = q/2;
        }
        return rem.toString();
    }

    int convertToDecimal(String binRep) {
        int res = 0;
        for(int i=0; i<binRep.length(); i++) {
            //int num = Character.getNumericValue(binRep.charAt(i));
            int num = (binRep.charAt(i)=='0')?0:1;
            res = (int) ((2 * res + num) % (Math.pow(10,9)+7));
        }
        return res;
    }*/

    public int concatenatedBinary(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String binRep = convertToBinary(i);
            for (int j = 0; j < binRep.length(); j++) {
                int num = (binRep.charAt(j) == '0') ? 0 : 1;
                res = (int) ((2 * res + num) % (Math.pow(10, 9) + 7));
            }

        }
        return res;

    }

    String convertToBinary(int i) {
        int q = i;
        StringBuilder rem = new StringBuilder();
        while (q != 0) {
            rem.insert(0, q % 2);
            q = q / 2;
        }
        return rem.toString();
    }

    int convertToDecimal(String binRep) {
        int res = 0;
        for (int i = 0; i < binRep.length(); i++) {
            //int num = Character.getNumericValue(binRep.charAt(i));
            int num = (binRep.charAt(i) == '0') ? 0 : 1;
            res = (int) ((2 * res + num) % (Math.pow(10, 9) + 7));
        }
        return res;
    }

    public static void main(String args[]) {
       /* System.out.println(new ConcatenateConsecutiveBinaryNumbers().concatenatedBinary(1));
        System.out.println(new ConcatenateConsecutiveBinaryNumbers().concatenatedBinary(3));
        System.out.println(new ConcatenateConsecutiveBinaryNumbers().concatenatedBinary(12));*/
        System.out.println(new ConcatenateConsecutiveBinaryNumbers().concatenatedBinary(42));
        System.out.println(new ConcatenateConsecutiveBinaryNumbers().concatenatedBinary(71439));
        // System.out.println(new ConcatenateConsecutiveBinaryNumbers().concatenatedBinary(5));
    }
}
