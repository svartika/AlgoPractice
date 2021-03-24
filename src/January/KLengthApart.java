package January;

public class KLengthApart {
    public boolean kLengthApart(int[] nums, int k) {
        Integer indexOfPrev1 = null;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1) {
                if(indexOfPrev1==null) indexOfPrev1=i;
                else if(i-indexOfPrev1 > k) indexOfPrev1=i;
                else return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
       /* int[] nums = new int[] {1,0,0,0,1,0,0,1};
        int k = 2;*/

        /*int[] nums = new int[] {1,0,0,1,0,1};
        int k = 2;*/

        /*int[] nums = new int[] {1,1,1,1,1};
        int k = 0;*/

        /*int[] nums = new int[] {0,1,0,1};
        int k = 1;*/

        int[] nums = new int[] {0,0,0,0};
        int k = 1;

         System.out.println(new KLengthApart().kLengthApart(nums, k));
    }
}
