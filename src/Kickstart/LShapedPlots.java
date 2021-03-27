package Kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LShapedPlots {

    private int numOfLAtGivenPoint(int[][] matrix, int startI, int startJ) {
        int verticalLen = 0, horizontalLen = 0;
        for (int i = startI; i < matrix.length; i++) {
            if (matrix[i][startJ] == 1) verticalLen++;
            else break;
        }
        for (int j = startJ; j < matrix[startI].length; j++) {
            if (matrix[startI][j] == 1) horizontalLen++;
            else break;
        }
        int numL1 = 0;
        if(horizontalLen>1 && verticalLen>1) numL1 = findNumberOfL(horizontalLen, verticalLen);

        verticalLen = 0; horizontalLen = 0;
        for (int i = startI; i < matrix.length; i++) {
            if (matrix[i][startJ] == 1) verticalLen++;
            else break;
        }
        for (int j = startJ; j >= 0; j--) {
            if (matrix[startI][j] == 1) horizontalLen++;
            else break;
        }
        int numL2 = 0;
        if(horizontalLen>1 && verticalLen>1)  numL2 = findNumberOfL(horizontalLen, verticalLen);

        verticalLen = 0; horizontalLen = 0;
        for (int i = startI; i >= 0; i--) {
            if (matrix[i][startJ] == 1) verticalLen++;
            else break;
        }
        for (int j = startJ; j < matrix[startI].length; j++) {
            if (matrix[startI][j] == 1) horizontalLen++;
            else break;
        }
        int numL3 = 0;
        if(horizontalLen>1 && verticalLen>1)  numL3 = findNumberOfL(horizontalLen, verticalLen);

        verticalLen = 0; horizontalLen = 0;
        for (int i = startI; i >= 0; i--) {
            if (matrix[i][startJ] == 1) verticalLen++;
            else break;
        }
        for (int j = startJ; j >= 0; j--) {
            if (matrix[startI][j] == 1) horizontalLen++;
            else break;
        }
        int numL4 = 0;
        if(horizontalLen>1 && verticalLen>1)  numL4 = findNumberOfL(horizontalLen, verticalLen);

        //System.out.println("i:" + startI + " j:" + startJ + " " + numL1 + " " + numL2 + " " + numL3 + " " + numL4);
        int numL = numL1 + numL2 + numL3 + numL4;
        return numL;
    }

    private int findNumberOfL(int lenJ, int lenI) {
        int smallSide, longSide;
        if (lenI <= lenJ) {
            smallSide = lenI;
            longSide = lenJ;
        } else {
            smallSide = lenJ;
            longSide = lenI;
        }
        int smallSideMod = Math.min((int)Math.floor(longSide/2), smallSide) -1;
        int longSideAsSmall = smallSide>=4 ? (smallSide/2)-1: 0;
        int count = smallSideMod + longSideAsSmall;
        return count;
    }

    public int countL(int[][] matrix) {
        int countL=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                countL += numOfLAtGivenPoint(matrix, i, j);
            }
        }
        return countL;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfTestCases = scanner.nextInt();
        LShapedPlots obj = new LShapedPlots();
        for(int i=1; i<= numOfTestCases; ++i) {
            int numRows = scanner.nextInt();
            int numCols = scanner.nextInt();
            int[][]matrix = new int[numRows][numCols];
            for(int j=0; j<numRows; j++)
                for(int k=0; k<numCols; k++)
                    matrix[j][k] = scanner.nextInt();
            int countL = obj.countL(matrix);
            String output = "Case #" + i + ": " + countL;
            System.out.println(output);
        }
    }
}
