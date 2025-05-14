import java.util.*;

class PostfixExpression {
    // NOTE: Please do not modify this function
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        int val = postfixExpression(exp);
        System.out.println(val);
    }

    // TODO: Implement this method
    static int postfixExpression(String exp) {
        //create a stack
        Stack<Integer> st = new Stack<>();

        //split string into array to check each element
        String []splitedExp = exp.split(" ");
        //initialize and looping till length
        int i =0;
        while (i < splitedExp.length) {
            int a=0,b=0;
            //check whether element is operator or operand
            //if operator perform calculation and push back the result
            if (splitedExp[i].equals("*")){
                b = st.pop();
                a = st.pop();
                st.push(a*b);
            }else if (splitedExp[i].equals("-")){
                b = st.pop();
                a = st.pop();
                st.push(a-b);
            }else if (splitedExp[i].equals("+")){
                b = st.pop();
                a = st.pop();
                st.push(a+b);
            }
            //if operand, push it to the stack
            else {
                st.push(Integer.parseInt(splitedExp[i]));
            }
            i++;
        }
        return st.peek();
    }
}
