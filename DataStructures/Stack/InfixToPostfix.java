import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {

        String input = "a+b-c";
        InfixToPostfix obj = new InfixToPostfix();
        String output = obj.covnertInfixToPostfix(input);
        System.out.println(output);

    }

    private String covnertInfixToPostfix(String input) {

        Stack<Character> operatorStack = new Stack<>();
        char[] inputCharArr = input.toCharArray();
        String output = "";

        int i = 0;
        int length = inputCharArr.length;

        while (i < length) {
            char currentCharacter = inputCharArr[i];

            if (Character.isLetterOrDigit(currentCharacter)) {
                output += currentCharacter;
            } else {
                operatorStack.add(currentCharacter);

            }
            i++;
        }

        while (operatorStack.size() > 0) {
            output += operatorStack.pop();
        }

        return output;
    }

}
