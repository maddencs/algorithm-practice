public class SimpleCalculator {
    public static void compute(LinkedList<String> operands, String operator){
        float op1 = Float.parseFloat(operands.pop());
        float op2 = Float.parseFloat(operands.pop());
        System.out.println("Operation: " + op2 + operator + op1);
        if(operator.equals("/")){
            operands.push(Float.toString(op2/op1));
        } else if(operator.equals("*")){
            operands.push(Float.toString(op1*op2));
        } else if(operator.equals("+")){
            operands.push(Float.toString(op1 + op2));
        } else if(operator.equals("-")){
            operands.push(Float.toString(op2 - op1));
        }
    }

    public static String calculate(String mathString) {
        String[] calculationList = mathString.split(" ");
        LinkedList<String> operands = new LinkedList<>(mathString.length());
        LinkedList<String> operators = new LinkedList<>(mathString.length());
        for(String s: calculationList){
            if(s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-")){
                operators.push(s);
            } else if(s.equals(")")){
                compute(operands, operators.pop());
            } else{
                operands.push(s);
            }
        }
        return operands.next();
    }

    public static void main(String[] args) {
        String testString1 = "(( 1 + 2 ) * 4 ) - 8 )"; // == 4
        String testString2 = "(( 100 / 10 ) * 6 ) + 3 )"; // 63
        System.out.println(testString1 + " = " + calculate(testString1));
        System.out.println(testString2 + " = " + calculate(testString2));
    }
}
