package Strings;

public class ReverseString {
    public void reverseString(char[] s) {
        for(int i=0; i<s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
    public static void main(String[] args) {
        char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
        new ReverseString().reverseString(s);
        /*for(int i=0; i<s.length; i++) */System.out.print(s);
        System.out.println();
    }
}
