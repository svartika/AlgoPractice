package Arrays;

public class RotateImage {
    void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=i+1; j<matrix[i].length; j++) {
                int temp =  matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    void reverse(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length-1-j];
                matrix[i][matrix[i].length-1-j] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    public static  void main(String args[]) {
        int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        new RotateImage().rotate(matrix);
    }
}
