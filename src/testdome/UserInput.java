package testdome;

public class UserInput {

    public static class TextInput {
        StringBuilder sb= new StringBuilder();
        public void add(char c) {
            sb.append(c);
        }

        public String getValue() {
            return sb.toString();
        }
    }

    public static class NumericInput extends TextInput {
        private boolean isDigit(char c) {
            if(c>='0' && c<='9') return true;
            return  false;
        }

        public void add(char c) {
            if(isDigit(c)) super.add(c);
        }
    }

    public static void main(String[] args) {
        //TextInput input = new NumericInput();
        //input.add('1');
        //input.add('a');
        //input.add('0');
        //System.out.println(input.getValue());
    }
}
