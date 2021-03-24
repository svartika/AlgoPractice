package January;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s==null || s.isEmpty()) return false;
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(isOpenParentheses(ch)) {
                stk.push(ch);
            } else if(isCloseParentheses(ch)) {
                if(stk.isEmpty()) return false;
                char openParenthes = stk.pop();
                if(!compareParentheses(openParenthes, ch)) return false;
            }
        }
        if(stk.isEmpty()) return true;
        else return false;
    }

    private boolean isOpenParentheses(char ch) {
        if(ch=='(' || ch=='{' || ch=='[') return true;
        else return false;
    }

    private boolean isCloseParentheses(char ch) {
        if(ch==')' || ch=='}' || ch==']') return true;
        else return false;
    }

    private boolean compareParentheses(char openParentheses, char closeParentheses) {
        if(openParentheses=='(' && closeParentheses==')') return true;
        if(openParentheses=='{' && closeParentheses=='}') return true;
        if(openParentheses=='[' && closeParentheses==']') return true;
        else return false;
    }

    public static void main(String args[]) {
        System.out.println(new ValidParentheses().isValid("()"));
        System.out.println(new ValidParentheses().isValid("()[]{}"));
        System.out.println(new ValidParentheses().isValid("(]"));
        System.out.println(new ValidParentheses().isValid("([)]"));
        System.out.println(new ValidParentheses().isValid("{[]}"));
        System.out.println(new ValidParentheses().isValid("]"));
    }
}
