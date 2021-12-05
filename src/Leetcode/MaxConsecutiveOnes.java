package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnes {

    public static void main(String args[]) {
        //int arr[] = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        //int arr[] = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        //int arr[] = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1        };
        //int arr[] = new int[]{0,0,1,1,1,0,0};
        int arr[] = new int[]{0,0,0,0};
        //int arr[] = new int[]{1,1,1,0,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,1,0,1,1,1,1,1,1,0,1,0,0,0,0,1,0,1,1,0,1,0,1,0,0,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,0,0,0,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,1,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,1,0,1,0,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0,1,0,0,1,0,0,0,0,1,1,0,1,1,1,0,0,1,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,1,1,1,1,0,0,1,0,0,0,0,1,1,1,1,0,0,1,0,0,1,0,0,0,0,0,1,1,0,1,1,0,1,0,0,1,1,1,0,1,0,0,0,0,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,1,1,1,1,1,0,0,1,1,0,1,1,1,0,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,1,1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,1,0,1,1,1,0,1,1,0,1,0,0,1,0,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,1,0,0,1,0,1,1,1,1,1,0,1,0,0,0,0,1,1,0,1,1,0,1,1,0,1,0,1,1,1,0,0,1,0,1,1,0,0,0,0,1,1,0,1,1,1,0,1,1,1,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,1,1,1,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1,0,0,1,0,1,0,0,1,1,1,0,1,0,1,1,0,0,1,1,0,1,1,0,0,0,0,0,0,0,1,0,1,1,0,1,1,0,0,0,0,0,0,1,0,1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0,0,1,0,1,1,1,1,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,0,1,1,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,1,1,1,1,0,1,0,1,0,0,0,0,0,1,0,0,1,0,0,1,1,0,0,1,1};

        int k = 0;
        int maxLen = new MaxConsecutiveOnes().longestOnes(arr, k);
        System.out.println("MaxLen: " + maxLen);
    }

    public int longestOnes(int[] nums, int k) {
        int start = 0, end = -1, flipCount = 0, maxLen = 0, maxStart = 0, maxEnd = 0;
        int[] numOfZeroesBeforeIndex = new int[nums.length];

        Queue<Integer> queue = new LinkedList();
        for (int index = 1; index < nums.length; index++) {
            numOfZeroesBeforeIndex[index] = numOfZeroesBeforeIndex[index-1] + (nums[index - 1] == 0?1:0);
            if(nums[index-1]==0 && nums[index]==1) {
                //System.out.println(String.format("JumpIndex: %d", index));
                queue.add(index);
            }
        }
        for (int index = start; index < nums.length; ) {
            if (nums[index] == 0) {
                if (flipCount < k) {
                    flipCount++;
                    end++;
                    if(end -start +1 >= maxLen) {
                        maxStart = start;
                        maxEnd = end;
                        maxLen = end -start +1;
                    }
                    //System.out.println(String.format("1...index: %d Start: %d end: %d maxLen: %d maxStart: %d maxEnd : %d flipCount: %d", index, start, end, maxLen, maxStart, maxEnd, flipCount));
                    index++;
                } else {
                    if(end -start +1 >= maxLen) {
                        maxStart = start;
                        maxEnd = end;
                        maxLen = end -start +1;
                    }
                    if(queue.isEmpty()) break;
                    int newStart = queue.remove();
                    flipCount = flipCount - (numOfZeroesBeforeIndex[newStart] - numOfZeroesBeforeIndex[start]);
                    //System.out.println(String.format("2...index: %d Start: %d end: %d maxLen: %d maxStart: %d maxEnd : %d flipCount: %d", index, start, end, maxLen, maxStart, maxEnd, flipCount));

                    start = newStart;


                }
            } else {

                end++;

                if(end -start +1 >= maxLen) {
                    maxStart = start;
                    maxEnd = end;
                    maxLen = end -start +1;
                }
                //System.out.println(String.format("3...index: %d Start: %d end: %d maxLen: %d maxStart: %d maxEnd : %d flipCount: %d", index, start, end, maxLen, maxStart, maxEnd, flipCount));
                index++;

            }

        }
        //int diff = k-flipCount;
        if(maxLen==0) return Math.min(k, nums.length);
        int diff = k-(numOfZeroesBeforeIndex[maxEnd] - numOfZeroesBeforeIndex[maxStart] + (nums[maxEnd]==0?1:0));

        //System.out.println(numOfZeroesBeforeIndex[maxEnd] - numOfZeroesBeforeIndex[maxStart] + (nums[maxEnd]==0?1:0));
        return maxLen + Math.min(diff, maxStart);

    }
}
