# Expression Evaluator

Arithmetic expression evaluator in Java implementing operator precedence parsing and parenthetical grouping.

## Problem Description
Evaluate a string mathematical expression containing integers, `+`, `-`, `*`, `/`, and parentheses `()`.

### Example
- Input: `"3 + 2 * (10 / 2) - 5"`
- Output: `8`

## Approach & Complexity
Two-stack Shunting-yard inspired evaluation:
1. `nums` stack holds numeric operands.
2. `ops` stack holds operators, unwinding on precedence changes or closing parentheses.

- **Time Complexity:** $O(N)$
- **Space Complexity:** $O(N)$

## How to Run & Test
```bash
javac -d bin src/ExpressionEvaluator.java tests/ExpressionEvaluatorTest.java
java -cp bin -ea ExpressionEvaluatorTest
```
