public class ExpressionEvaluatorTest {
    public static void main(String[] args) {
        assert ExpressionEvaluator.evaluate("3 + 2 * 2") == 7 : "Test 1 Failed";
        assert ExpressionEvaluator.evaluate(" 3/2 ") == 1 : "Test 2 Failed";
        assert ExpressionEvaluator.evaluate(" 3 + 5 / 2 ") == 5 : "Test 3 Failed";
        assert ExpressionEvaluator.evaluate("(1+(4+5+2)-3)+(6+8)") == 23 : "Test 4 Failed";
        System.out.println("All ExpressionEvaluator tests passed!");
    }
}
