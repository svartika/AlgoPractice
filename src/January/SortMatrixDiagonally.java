package January;

import java.util.Arrays;

public class SortMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        int numRows = mat.length;
        int numCols = mat[0].length;
        if(numRows<=1 || numCols<=1) return mat;

        sortRowDiagonals(mat, numRows, numCols);
        sortColDiagonals(mat, numRows, numCols);

        return mat;
    }

    void sortRowDiagonals(int[][] mat, int numRows, int numCols) {
        for(int i=0; i<numCols-1; i++) {
            sortADiagonal(mat, 0, i, numRows, numCols);
        }
    }

    void sortColDiagonals(int[][] mat, int numRows, int numCols) {
        for(int i=1; i<numRows-1; i++) {
            sortADiagonal(mat, i, 0, numRows, numCols);
        }
    }

    void sortADiagonal(int[][] mat, int rowIndex, int colIndex, int numRows, int numCols) {
        int numRowsInDiagonal = numRows - rowIndex;
        int numColsInDiagonal = numCols - colIndex;
        int[] arr = new int[Math.min(numRowsInDiagonal, numColsInDiagonal)];
        int rowIter = rowIndex;
        int colIter = colIndex;
        for(int i=0; i< arr.length; i++) {
            arr[i] = mat[rowIter++][colIter++];
            //rowIter++; colIter++;
        }
        quickSort(arr, 0, arr.length-1);
        rowIter = rowIndex;
        colIter = colIndex;
        for(int i=0; i< arr.length; i++) {
            mat[rowIter++][colIter++] = arr[i];
        }
    }

    void quickSort(int[] arr, int p, int r) {
        if(p<r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
        }
    }

    int partition(int[] arr, int p, int r) {
        int i = p-1;
        int x = arr[r];
        for(int j=p; j<r; j++) {
            if(arr[j]<=x) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }

    public static void main(String args[]) {
        int[][] mat = new int [][] {{3,3,1,1}, {2,2,1,2}, {1,1,1,2}};
        //int[][] mat = new int[][] {{75,21,13,24,8},{24,100,40,49,62}};
        for(int i=0; i<mat.length; i++) {
            System.out.println();
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
        }
        int[][] res = new SortMatrixDiagonally().diagonalSort(mat);
        System.out.println(Arrays.toString(res));
        for(int i=0; i<res.length; i++) {
            System.out.println();
            for (int j = 0; j < res[i].length; j++)
                System.out.print(res[i][j] + " ");
        }
    }
}
