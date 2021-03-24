package February;

import java.util.ArrayList;
import java.util.List;

public class KWeakestRows {
    private class Pair {
        int pos, soldiers;
        Pair(int pos, int soldiers) {
            this.pos=pos; this.soldiers=soldiers;
        }
    }

    int partition(List<Pair>weakRows, int p, int r) {
        int i=p-1;
        Pair x=weakRows.get(r);
        for(int j=p; j<r; j++) {
            if((weakRows.get(j).soldiers<x.soldiers) ||
                    (weakRows.get(j).soldiers==x.soldiers && weakRows.get(j).pos<x.pos) ){
                i++;
                Pair temp = weakRows.get(j);
                weakRows.set(j, weakRows.get(i));
                weakRows.set(i, temp);
            }

        }
        i++;
        Pair temp = x;
        weakRows.set(r, weakRows.get(i));
        weakRows.set(i, temp);
        return i;
    }

    void quickSort(List<Pair> weakRows, int start, int end) {
        if(start<end) {
            int q = partition(weakRows, start, end);
            quickSort(weakRows,start, q-1);
            quickSort(weakRows, q+1, end);
        }
    }

    private int maxStrenghtInArr(  List<Pair> weakRows, int maxAt) {
        if(weakRows.size()<maxAt || weakRows.get(maxAt-1)==null)return Integer.MAX_VALUE;
        return weakRows.get(maxAt-1).soldiers;
    }

    private void insertInArr(List<Pair>weakRows, int row, int soldiers, int max) {
        Pair temp=new Pair(row, soldiers);
        weakRows.add(temp);
        quickSort(weakRows, 0, weakRows.size()-1);
        if(weakRows.size()==max+1) weakRows.remove(max);
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Pair> weakRows = new ArrayList<Pair>();
        for(int i=0; i<mat.length; i++) {
            int soldierCount=0;
            int maxValueInArray = maxStrenghtInArr(weakRows, k);
            if(maxValueInArray==0) {
                if(mat[i][maxValueInArray]==1) continue;
            }else if(maxValueInArray<Integer.MAX_VALUE) {
                if(mat[i][maxValueInArray-1]==1) continue;
            }
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j]==0) break;
                else soldierCount++;
                if(soldierCount>maxValueInArray) break;
            }
            if(soldierCount<maxValueInArray)
                insertInArr(weakRows, i, soldierCount,k);
        }
        int[] orderedArr = new int[k];
        for(int i=0; i<k; i++) {
            orderedArr[i] = weakRows.get(i).pos;
        }
        return orderedArr;
    }

    public static void main(String [] args){
        int[][]mat = new int[][]{ {1,1,0,0,0},{1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1} };
        int k=3;
        new KWeakestRows().kWeakestRows(mat, k);
    }
}
