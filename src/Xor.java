import java.util.List;
import java.util.Map;

/**
 * The And class represents the mathematical operator Xor.
 */
public class Xor extends BinaryExpression {
    /**
     * Creates a new Xor object.
     * @param left the expression on the left side of the operator.
     * @param right the expression on the right side of the operator.
     */
    public Xor(Expression left, Expression right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (left == null || right == null) {
            throw new Exception("The left expression or the right expression is null, can't evaluate the expression.");
        }
        if (left.evaluate(assignment) == null || right.evaluate(assignment) == null) {
            throw new Exception(
                    "The left expression value or the right expression value is null, can't evaluate the expression.");
        }
        return ((!left.evaluate(assignment) && right.evaluate(assignment))
                || (left.evaluate(assignment) && !right.evaluate(assignment)));
    }

    @Override
    public Boolean evaluate() throws Exception {
        if (left == null || right == null) {
            throw new Exception("The left expression or the right expression is null, can't evaluate the expression.");
        }
        if (left.evaluate() == null || right.evaluate() == null) {
            throw new Exception(
                    "The left expression value or the right expression value is null, can't evaluate the expression.");
        }
        return ((!left.evaluate() && right.evaluate()) || (left.evaluate() && !right.evaluate()));
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression eLeft = left.assign(var, expression);
        Expression eRight = right.assign(var, expression);
        return new Xor(eLeft, eRight);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " ^ " + right.toString() + ")";
    }

    @Override
    public Expression nandify() {
        return new Nand(
                new Nand(
                        left.nandify(),
                        new Nand(
                                left.nandify(),
                                right.nandify())),
                new Nand(
                        right.nandify(),
                        new Nand(
                                left.nandify(),
                                right.nandify())));
    }

    @Override
    public Expression norify() {
        return new Nor(
                new Nor(
                        new Nor(
                                left.norify(),
                                left.norify()),
                        new Nor(
                                right.norify(),
                                right.norify())),
                new Nor(
                        left.norify(),
                        right.norify()));
    }

    @Override
    public Expression simplify() {
        if (left.simplify().toString().equals("T")) {
            return new Not(right.simplify());
        }
        if (right.simplify().toString().equals("T")) {
            return new Not(left.simplify());
        }
        if (left.simplify().toString().equals("F")) {
            return right.simplify();
        }
        if (right.simplify().toString().equals("F")) {
            return left.simplify();
        }
        if (left.simplify().toString().equals(right.simplify().toString())) {
            return new Val(false);
        }
        return new Xor(left.simplify(), right.simplify());
    }
}