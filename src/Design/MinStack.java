package Design;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> nums;
    int min=Integer.MAX_VALUE;
    int countMin=0;
    /** initialize your data structure here. */
    public MinStack() {
        nums = new ArrayList<>();
    }

    public void push(int x) {
        nums.add(x);
        min = Math.min(min, x);
    }

    public void pop() {
        if(nums.get(nums.size()-1)==min) {
            nums.remove(nums.size()-1);
            min = Integer.MAX_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
            }
        } else {
            nums.remove(nums.size() - 1);
        }
    }

    public int top() {
        return nums.get(nums.size()-1);
    }

    public int getMin() {
        return min;
    }

    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
