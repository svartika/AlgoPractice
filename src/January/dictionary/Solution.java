package January.dictionary;

import java.util.List;
import java.util.Stack;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean loop = true;
        String remainingPart = s;
        int indexToStartLookingFrom = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        while(!stack.empty()) {
            indexToStartLookingFrom = stack.pop();
            int indexWhereNextStartMatchIsFound = findMatchingStartingInDictionary(remainingPart, wordDict, indexToStartLookingFrom);
            if(indexWhereNextStartMatchIsFound>-1) {
                stack.push(indexWhereNextStartMatchIsFound);
                remainingPart = remainingPart.substring(wordDict.get(indexWhereNextStartMatchIsFound).length());
                stack.push(0);
            } else {
                //remainingPart = wordDict
            }
        }
        return true;
    }

    public int findMatchingStartingInDictionary(String s, List<String> wordDict, int startingIndexInDictionary) {
        for(int i = startingIndexInDictionary; i < wordDict.size(); i++) {
            if(s.startsWith(wordDict.get(i))) {
                return i;
            }
        }
        return -1;
    }
}