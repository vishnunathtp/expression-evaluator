import java.util.Stack;

public class ExpressionEvaluator {
    public static int evaluate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                nums.push(val);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
        }

        return nums.isEmpty() ? 0 : nums.pop();
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b != 0 ? a / b : 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        String expr = "3 + 2 * (10 / 2) - 5";
        System.out.println(expr + " = " + evaluate(expr));
    }
}
