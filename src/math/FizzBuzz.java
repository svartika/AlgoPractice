package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        int[] divisors = new int[] {3,5};
        List<String> nums = new ArrayList<String>();
        for(int i=1; i<=n; i++) {
            String num = "";
            if(i%divisors[0]==0) num += "Fizz";
            if(i%divisors[1]==0) num += "Buzz";
            if(num.isEmpty()) num = String.valueOf(i);
            nums.add(num);
        }
        return nums;
    }
}
