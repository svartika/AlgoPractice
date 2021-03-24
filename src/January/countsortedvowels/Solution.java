package January.countsortedvowels;

public class Solution {
    public int countVowelStrings(int n) {
        return count('a', n);
    }

    public int count(char start, int length) {
        int finalCount = 0;
        if(length==0) return 1;
        switch (start) {
            case 'a':
                finalCount += count('a', length-1);


            case 'e':
                finalCount += count('e', length-1);

            case 'i':
                finalCount += count('i', length-1);

            case 'o':
                finalCount += count('o', length-1);

            case 'u':
                finalCount += count('u', length-1);
        }
        return finalCount;
    }
}

/*
class Arrays.Solution {
    public int countVowelStrings(int n) {
        int [][] dp=new int[n+1][5];
        for(int i=0;i<5;i++)
            dp[0][i]=1;
        for(int i=0;i<n+1;i++)
            dp[i][0]=1;
        for(int i=1;i<n+1;i++)
            for(int j=1;j<5;j++)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
        return dp[n][4];
    }
}*/
