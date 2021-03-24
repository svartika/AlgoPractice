package February;

import java.util.Stack;

public class SimplifyPath {

    /*private Stack<String> createStack(String path) {
        Stack<String> stk = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);

            if (ch == '/') {
                if (str.toString().compareTo(".") == 0) {
                    str.delete(0, str.length());
                } else if (str.toString().compareTo("..") == 0) {
                    str.delete(0, str.length());
                    if (stk.size() > 1) {

                        if (!stk.isEmpty()) stk.pop();
                        if (!stk.isEmpty()) stk.pop();
                    }
                } else {
                    if (!str.toString().isEmpty()) {
                        stk.push(str.toString());
                        str.delete(0, str.length());
                        stk.push("/");
                    } else if(stk.isEmpty()) {
                        stk.push("/");
                    }
                }
            } else {
                str.append(ch);
            }
            if (i == path.length() - 1) {
                if (stk.isEmpty()) stk.push("/");
                if (!str.toString().isEmpty()) {
                    if (str.toString().compareTo("..") == 0) {
                        if (stk.size() > 1) {
                            if (!stk.isEmpty()) stk.pop();
                            if (!stk.isEmpty()) stk.pop();
                        }
                    } else if (str.toString().compareTo(".") != 0) {
                        stk.push(str.toString());
                    }
                }
            }
        }
        return stk;
    }

    private String createCanonicalName(Stack<String> stk) {
        StringBuilder str = new StringBuilder();
        while (!stk.isEmpty()) {
            str.insert(0, stk.pop());
        }
        if (str.length() > 1) {
            while (str.charAt(str.length() - 1) == '/') str.deleteCharAt(str.length() - 1);
        }
        return str.toString();
    }*/

    private Stack<String> createStack(String path) {
        if(path.charAt(path.length()-1)!='/') path = path + "/";
        Stack<String> stk = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == '/') {
                if (str.toString().compareTo(".") == 0) {
                } else if (str.toString().compareTo("..") == 0) {
                    if (!stk.isEmpty()) stk.pop();
                } else {
                    if (!str.toString().isEmpty()) {
                        stk.push(str.toString());
                    }
                }
                str.delete(0, str.length());
            } else {
                str.append(ch);
            }
        }
        return stk;
    }

    private String createCanonicalName(Stack<String> stk) {
        StringBuilder str = new StringBuilder();
        if(stk.isEmpty()) str.append("/");
        while (!stk.isEmpty()) {
            str.insert(0,"/");
            str.insert(1, stk.pop());
        }
        return str.toString();
    }

    public String simplifyPath(String path) {
        Stack<String> stk = createStack(path);
        return createCanonicalName(stk);
    }

    public static void main(String[] args) {
       /* System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/"));
        System.out.println(new SimplifyPath().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new SimplifyPath().simplifyPath("/../"));
        System.out.println(new SimplifyPath().simplifyPath("/a//b////c/d//././/.."));
        System.out.println(new SimplifyPath().simplifyPath("/"));
        System.out.println(new SimplifyPath().simplifyPath("/..."));
        System.out.println(new SimplifyPath().simplifyPath("/hello../world"));
        System.out.println(new SimplifyPath().simplifyPath("/home/../../.."));*/
        System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/"));

    }
}
