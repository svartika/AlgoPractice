package February;

import java.util.Stack;

public class MinRemovesToMakeValidParenthesis {
    class ItemAndPos {
        char item;
        int pos;
        ItemAndPos(char item, int pos) { this.item=item; this.pos=pos; }
    }

    public String minRemoveToMakeValid(String s) {
        Stack<ItemAndPos> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(! (c>='a' && c<='z') ) {
                if(c==')' && !stack.isEmpty() && stack.peek().item=='(') stack.pop();
                else stack.push(new ItemAndPos(c, i));
            }
        }
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        while(!stack.isEmpty()) {
            int pos = stack.pop().pos;
            sb.deleteCharAt(pos);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println(new MinRemovesToMakeValidParenthesis().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(new MinRemovesToMakeValidParenthesis().minRemoveToMakeValid("))(("));
        System.out.println(new MinRemovesToMakeValidParenthesis().minRemoveToMakeValid("a)b(c)d"));
    }
}
