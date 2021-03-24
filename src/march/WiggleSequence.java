package march;

public class WiggleSequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1) return 1;
        if(nums.length==2) {
            if(nums[1]-nums[0]==0) return 1;
            else return 2;
        }
        Boolean lookForIncreaseNext=null, lookForDecreaseNext=null;
        int len = 0;
        int diff = nums[1]-nums[0];
        if(diff>0) {
            lookForDecreaseNext = true;
            lookForIncreaseNext = false;
            len=1;
        }
        else if(diff<0) {
            lookForIncreaseNext = true;
            lookForDecreaseNext = false;
            len=1;
        }
        for(int i=2; i<nums.length; i++) {
            diff = nums[i] - nums[i-1];
            if(lookForDecreaseNext==null && lookForIncreaseNext==null) {
                if(diff>0) {
                    lookForDecreaseNext = true;
                    lookForIncreaseNext = false;
                    len++;
                }
                else if(diff<0) {
                    lookForIncreaseNext = true;
                    lookForDecreaseNext = false;
                    len++;
                }
            } else if(lookForDecreaseNext) {
                if(diff<0) {
                    lookForDecreaseNext=false;
                    lookForIncreaseNext=true;
                    len++;
                }
            } else if(lookForIncreaseNext) {
                if(diff>0) {
                    lookForIncreaseNext=false;
                    lookForDecreaseNext=true;
                    len++;
                }
            }
        }
        return len+1;
    }

    public static void main(String args[]) {
       /* int [] nums = new int[] {1, 7, 4, 9, 2, 5};
        System.out.println(new WiggleSequence().wiggleMaxLength(nums));

        int [] nums1 = new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(new WiggleSequence().wiggleMaxLength(nums1));

        int [] nums2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new WiggleSequence().wiggleMaxLength(nums2));

        int [] nums3 = new int[] {1, 4, 7, 2, 5};
        System.out.println(new WiggleSequence().wiggleMaxLength(nums3));*/

        /*int [] nums4 = new int[] {0,0,0};
        System.out.println(new WiggleSequence().wiggleMaxLength(nums4));*/

        int [] nums5 = new int[] {3,3,3,2,5};
        System.out.println(new WiggleSequence().wiggleMaxLength(nums5));
    }
}
