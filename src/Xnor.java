import java.util.Map;

/**
 * The And class represents the mathematical operator Xnor.
 */
public class Xnor extends BinaryExpression {
    /**
     * Creates a new Xnor object.
     * @param left the expression on the left side of the operator.
     * @param right the expression on the right side of the operator.
     */
    public Xnor(Expression left, Expression right) {
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
        return !((!left.evaluate(assignment) && right.evaluate(assignment))
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
        return !((!left.evaluate() && right.evaluate()) || (left.evaluate() && !right.evaluate()));
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression eLeft = left.assign(var, expression);
        Expression eRight = right.assign(var, expression);
        return new Xnor(eLeft, eRight);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " # " + right.toString() + ")";
    }


    @Override
    public Expression nandify() {
        return new Nand(
                new Nand(
                        new Nand(
                                left.nandify(),
                                left.nandify()),
                        new Nand(
                                right.nandify(),
                                right.nandify())),
                new Nand(
                        left.nandify(),
                        right.nandify()));
    }

    @Override
    public Expression norify() {
        return new Nor(
                new Nor(
                        left.norify(),
                        new Nor(
                                left.norify(),
                                right.norify())),
                new Nor(
                        right.norify(),
                        new Nor(
                                left.norify(),
                                right.norify())));
    }

    @Override
    public Expression simplify() {
        if ((left.simplify().toString().equals("F") && right.simplify().toString().equals("T"))
        || (left.simplify().toString().equals("T") && right.simplify().toString().equals("F"))) {
            return new Val(false);
        }
        if (left.simplify().toString().equals((right.simplify().toString()))) {
            return new Val(true);
        }
        return new Xnor(left.simplify(), right.simplify());
    }
}