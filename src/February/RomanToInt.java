package February;

public class RomanToInt {
    public int romanToInt(String s) {
        int num=0;
        for(int i=s.length()-1; i>=0; i--) {
            char ch = s.charAt(i);
            int sub=0;
            switch (ch) {
                case 'I':

                    num+=1;
                    break;
                case 'V':
                    if (i-1>=0) {
                        char lookAhead = s.charAt(i-1);
                        if(lookAhead=='I') {
                            num += 4;
                            i--;
                        }
                        else num+=5;
                    }
                    else num+=5;
                    break;
                case 'X':
                    if (i-1>=0) {
                        char lookAhead = s.charAt(i-1);
                        if(lookAhead=='I') {
                            num += 9;
                            i--;
                        }
                        else num+=10;
                    }
                    else num+=10;
                    break;
                case 'L':
                    if (i-1>=0) {
                        char lookAhead = s.charAt(i-1);
                        if(lookAhead=='X') {
                            num+=40;
                            i--;
                        }
                        else num+=50;
                    }
                    else num+=50;
                    break;
                case 'C':
                    if (i-1>=0) {
                        char lookAhead = s.charAt(i-1);
                        if(lookAhead=='X') {
                            num+=90;
                            i--;
                        }
                        else num+=100;
                    }
                    else num+=100;
                    break;
                case 'D':
                    if (i-1>=0) {
                        char lookAhead = s.charAt(i-1);
                        if(lookAhead=='C') {
                            num+=400;
                            i--;
                        }
                        else num+=500;
                    }
                    else num+=500;
                    break;
                case 'M':
                    if (i-1>=0) {
                        char lookAhead = s.charAt(i-1);
                        if(lookAhead=='C') {
                            num+=900;
                            i--;
                        }
                        else num+=1000;
                    }
                    else num+=1000;
                    break;
            }
        }
        return num;
    }
    public static void main(String args[]) {
        System.out.println(new RomanToInt().romanToInt("III"));
       System.out.println(new RomanToInt().romanToInt("IV"));
        System.out.println(new RomanToInt().romanToInt("IX"));
         System.out.println(new RomanToInt().romanToInt("LVIII"));
        System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
    }
}
