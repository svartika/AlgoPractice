package January;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindMostCompetitiveSubswequence {

    /*public int[] mostCompetitive(int[] nums, int k) {
        int i = 0, moveUpTo = nums.length - k;
        //int[] res = new int[k];
        Queue<Integer> q = new LinkedList<>();
        int resIndex = 0;
        while (i <= moveUpTo && resIndex < k) {
            int[] numAndIndex = findSmallestNumAndNewIndex(nums, i, moveUpTo);
            //res[resIndex++] = numAndIndex[0];
            resIndex++;
            q.add (numAndIndex[0]);
            i = numAndIndex[1] + 1;
            moveUpTo = moveUpTo + 1;
            if (moveUpTo >= nums.length) moveUpTo = nums.length - 1;
        }
        return q.stream().mapToInt(x->x).toArray();//res;
    }

    private int[] findSmallestNumAndNewIndex(int[] nums, int start, int end) {
        int[] res = new int[2];
        int min = nums[start];
        int minInd = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minInd = i;
            }
        }
        res[0] = min;
        res[1] = minInd;
        return res;
    }*/
    //above times out for large arrays
    //i am going to try using some stack or queue to hold smallest element at top

    public int[] mostCompetitive(int[] nums, int k) {
       /* Queue<Integer> q = new LinkedList<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            // while q is not empty and
            // the new value is less than the top most value and
            //the size of queue and num of elements in array - index is still greater than k -> this means if we use this number then we still have numbers remaining for the rest of k items needed
            while(!q.isEmpty() && nums[i]<q.peek() && q.size()+n-i>k) q.remove();

            // if no elements in queue or if some larger number or k elements not yet found so append this element
            if(q.size()<k) q.add(nums[i]);
        }
        int i =10;
        return q.stream().mapToInt(x->x).toArray();*/

        Stack<Integer> st = new Stack();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[i] < st.peek() && st.size() + n - i > k)
                st.pop();
            if(st.size() < k)
                st.push(nums[i]);
        }
        //int i= 10;
        return st.stream().mapToInt(x -> x).toArray();
    }



    public static void main(String args[]) {
       /* int[] nums = new int[] {3,5,2,6};
        int k = 2;*/

        int[] nums = new int[] {2,4,3,3,5,4,9,6};
        int k = 4;

        /*int[] nums = new int[] {1,1,1,1,1,0};
        int k = 3;*/

        /*int k = 50000;
        int bigArraySize = 100000;
        int[] nums = new int[bigArraySize];
        for(int index = 0 ; index < bigArraySize-1; index++) {
            nums[index] = 1;
        }*/

        int[] mostCompetitive = new FindMostCompetitiveSubswequence().mostCompetitive(nums, k);
        System.out.println(Arrays.toString(mostCompetitive));
    }
}
