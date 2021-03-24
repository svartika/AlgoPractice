package January;

public class PathWithMinEfforts {
    enum Direction { LEFT, RIGHT, TOP, DOWN}
    public int minimumEffortPath(int[][] heights) {
        return findMinEffort(heights, 0, 0);
    }
    int newLeastEffort=0;
    private int findMinEffort(int[][] heights, int i, int j) {

        if(i==heights.length-1 && j==heights.length-1) return newLeastEffort;

        if(heights[i][j]==Integer.MAX_VALUE) return Integer.MAX_VALUE;

        int d1 = goLeft(heights, i, j);
        int d2 = goRight(heights, i, j);
        int d3 = goUp(heights, i, j);
        int d4 = goDown(heights, i, j);

        heights[i][j] = Integer.MAX_VALUE;

        int minDistance = min(d1, d2, d3, d4);

        Direction dir = findMinDistanceDir(d1, d2, d3, d4);

        int newI=i,newJ=j;
        switch (dir) {
            case LEFT:
                newJ=j-1; break;
            case RIGHT:
                newJ=j+1; break;
            case TOP:
                newI=i-1; break;
            case DOWN:
                newI=i+1; break;
        }

        newLeastEffort = findMinEffort(heights, newI, newJ);

        return Math.max(newLeastEffort, minDistance);
    }



    Direction findMinDistanceDir(int d1, int d2, int d3, int d4) {
        if(d1<d2 && d1<d3 && d1<d4) return Direction.LEFT;
        else if(d2<d1 && d2<d3 && d2<d4) return Direction.RIGHT;
        else if(d3<d1 && d3<d2 && d3<d4) return Direction.TOP;
        else if(d4<d1 && d4<d2 && d4<d3) return Direction.DOWN;
        return Direction.LEFT;
    }

    int min(int d1, int d2, int d3, int d4) {
        return Math.min(Math.min(d1, d2), Math.min(d3, d4));
    }

    int goLeft(int[][] heights, int i, int j) {
        if(j==0) return Integer.MAX_VALUE;
        else {
            int heightOfLeft = heights[i][j-1];
            int heightCurrent = heights[i][j];
            return Math.abs(heightCurrent-heightOfLeft);
        }
    }
    int goRight(int[][] heights, int i, int j) {
        if(j>=heights[0].length-1) return Integer.MAX_VALUE;
        else {
            int heightOfRight = heights[i][j+1];
            int heightCurrent = heights[i][j];
            return Math.abs(heightCurrent-heightOfRight);
        }
    }
    int goUp(int[][] heights, int i, int j) {
        if(i==0) return Integer.MAX_VALUE;
        else {
            int heightOfUp = heights[i-1][j];
            int heightCurrent = heights[i][j];
            return Math.abs(heightCurrent-heightOfUp);
        }
    }
    int goDown(int[][] heights, int i, int j) {
        if(i>=heights.length-1) return Integer.MAX_VALUE;
        else {
            int heightOfDown = heights[i+1][j];
            int heightCurrent = heights[i][j];
            return Math.abs(heightCurrent-heightOfDown);
        }
    }

    public static void main(String[] args) {
        int[][] heights = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(new PathWithMinEfforts().minimumEffortPath(heights));
    }
}

