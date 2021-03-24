package February;

public class ArithmaticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<=2) return 0;
        int currSeqStartsAt = 0, numSlices=0;
        int progressionVal = A[1] - A[0];
        for(int i=2; i<A.length; i++) {
            int curProg = A[i] - A[i-1];
            if(curProg!=progressionVal) {
                numSlices += findNumberOfSlicesInGivenSeq(currSeqStartsAt, i);
                progressionVal = curProg;
                currSeqStartsAt = i-1;
            }
        }
        numSlices+=findNumberOfSlicesInGivenSeq(currSeqStartsAt, A.length);
        return numSlices;
    }

    private int findNumberOfSlicesInGivenSeq(int startInclusive, int endExclusive) {
        int numElems = endExclusive - startInclusive;
        int numSlices = 0;
        for(int sizeOfSet=3; sizeOfSet<=numElems; sizeOfSet++) {
            numSlices+=numElems-sizeOfSet+1;
        }
        return numSlices;
    }

    public static void main(String args[]) {
        int[]A = new int[] {1,2,3,4,5,17,8,10,12,14};
        System.out.println(new ArithmaticSlices().numberOfArithmeticSlices(A));
    }
}
