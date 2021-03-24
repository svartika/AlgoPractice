package February;

public class NumStepsToReduceToZero {
    public int numberOfSteps (int num) {
        int steps = 0;
        while(num!=0) {
            if(num%2==0) num/=2;
            else num-=1;
            steps++;
        }
        return steps;
    }

    public static void main(String args[]) {
        System.out.println(new NumStepsToReduceToZero().numberOfSteps(14));
        System.out.println(new NumStepsToReduceToZero().numberOfSteps(8));
        System.out.println(new NumStepsToReduceToZero().numberOfSteps(123));
    }
}
