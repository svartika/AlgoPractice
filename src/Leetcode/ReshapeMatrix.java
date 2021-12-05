package Leetcode;

public class ReshapeMatrix {

    public static void main(String args[]) {
        int mat[][] = new int[][]{{1, 2}, {3, 4}};
        int newMat[][] = new ReshapeMatrix().matrixReshape(mat, 1, 4);
        for (int i = 0; i < newMat.length; i++) {
            for (int j = 0; j < newMat[0].length; j++) {
                System.out.print(newMat[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return mat;
        int rows = mat.length;
        int cols = mat[0].length;
        if (rows * cols != r * c) return mat;

        int[][] newMat = new int[r][c];
        int oldRowIter = 0, oldColIter = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (oldColIter == cols) {
                    oldRowIter++;
                    oldColIter = 0;
                }
                newMat[i][j] = mat[oldRowIter][oldColIter++];
            }
        }
        return newMat;
    }
}
