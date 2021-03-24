package February;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length<=1) return 0;

        int max = Math.min(height[0], height[height.length-1]) * (height.length-1);
        for(int i=0, j=height.length-1; i<j; ) {
            if(height[i]<height[j]) {
                i = i + 1;
            } else {
                j = j -1;
            }
            if(i<j) {
                int newArea = Math.min(height[i], height[j]) * (j - i);
                if(newArea>max) {
                    max = newArea;
                }
            }

        }
        return max;
    }

    public static  void main(String args[]) {
        //int[] height = new int[] {1,2,4,3};
        //int[] height = new int[] {2,3,4,5,18,17,6};
        //int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        //int[] height = new int[] {1,1};
        int[] height = new int[] {1};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
