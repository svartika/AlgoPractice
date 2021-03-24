package Arrays;

public class ValidSudoku {
    private int[][] board = new int[9][9];

    private boolean isValidRow(int rowNum) {
        boolean[] visited = new boolean[9];
        for (int col = 0; col < 9; col++) {
            int num = board[rowNum][col]-1;
            if(num==-2) continue;
            if (visited[num] == true) return false;
            else visited[num] = true;
        }
        return true;
    }

    private boolean isValidColumn(int colNum) {
        boolean[] visited = new boolean[9];
        for (int row = 0; row < 9; row++) {
            int num = board[row][colNum]-1;
            if(num==-2) continue;
            if (visited[num] == true) return false;
            else visited[num] = true;
        }
        return true;
    }

    private boolean isValidSquare(int startRow, int startCol) {
        boolean[] visited = new boolean[9];
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                int num = board[i][j]-1;
                if(num==-2) continue;
                if (visited[num] == true) return false;
                else visited[num] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.board[i][j] =Character.getNumericValue(board[i][j]);
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(i)) return false;
            if (!isValidColumn(i)) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValidSquare(i * 3, j * 3)) return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        /*char[][] board =
                { {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'} };*/


        char[][] board =
                { {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'} };

        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}