package January.indivar;

import January.SortMatrixDiagonally;

import java.util.Arrays;

public class SortMatrixDialognally {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        if(rows<=1) return mat;
        int columsn = mat[0].length;
        if(columsn<=1) return mat;
        int columnOffsetMin = -rows+2;
        int columnOffsetMax = columsn-1;
        for(int columnOffset = columnOffsetMin; columnOffset < columnOffsetMax; columnOffset++) {

            int row  = 0;
            int col = row + columnOffset;

            System.out.println(String.format("ColumnOffset: "+ columnOffset));
        }
        return mat;
    }
    public void getItemAtIndexInDiagonal(int[][] mat, int index, int columnOffset, int rows, int columns) {
        int firstRow = (columnOffset<0)? -columnOffset:0 ;
        int firstColumn = columnOffset<0?0:columnOffset;
        int lastRow = columnOffset<0?rows-1:(rows-columnOffset)-1;
       // int lastColumn = columnOffset<0?columns-columnOffset-2:columnOffset+rows -1
    }
    public static void main(String args[]) {
        int[][] mat = new int [][] {{3,3,1,1}, {2,2,1,2}, {1,1,1,2}};
        //int[][] mat = new int[][] {{75,21,13,24,8},{24,100,40,49,62}};
        for(int i=0; i<mat.length; i++) {
            System.out.println();
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
        }
        int[][] res = new SortMatrixDialognally().diagonalSort(mat);
        System.out.println(Arrays.toString(res));
        for(int i=0; i<res.length; i++) {
            System.out.println();
            for (int j = 0; j < res[i].length; j++)
                System.out.print(res[i][j] + " ");
        }
    }
}
