import java.util.Map;

/**
 * The And class represents the mathematical operator Nand.
 */
public class Nand extends BinaryExpression {
    /**
     * Creates a new Nand object.
     * @param left the expression on the left side of the operator.
     * @param right the expression on the right side of the operator.
     */
    public Nand(Expression left, Expression right) {
        super.setLeft(left);
        super.setRight(right);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (getLeft() == null || getRight() == null) {
            throw new Exception("The left expression or the right expression is null, can't evaluate the expression.");
        }
        if (getLeft().evaluate(assignment) == null || getRight().evaluate(assignment) == null) {
            throw new Exception(
                    "The left expression value or the right expression value is null, can't evaluate the expression.");
        }
        return !(getLeft().evaluate(assignment) && getRight().evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        if (getLeft() == null || getRight() == null) {
            throw new Exception("The left expression or the right expression is null, can't evaluate the expression.");
        }
        if (getLeft().evaluate() == null || getRight().evaluate() == null) {
            throw new Exception(
                    "The left expression value or the right expression value is null, can't evaluate the expression.");
        }
        return !(getLeft().evaluate() && getRight().evaluate());
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression eLeft = getLeft().assign(var, expression);
        Expression eRight = getRight().assign(var, expression);
        return new Nand(eLeft, eRight);
    }

    @Override
    public String toString() {
        return "(" + getLeft().toString() + " A " + getRight().toString() + ")";
    }

    @Override
    public Expression nandify() {
        return new Nand(getLeft().nandify(), getRight().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(
                new Nor(
                        new Nor(
                                getLeft().norify(),
                                getLeft().norify()),
                        new Nor(
                                getRight().norify(),
                                getRight().norify())),
                new Nor(
                        new Nor(
                                getLeft().norify(),
                                getLeft().norify()),
                        new Nor(
                                getRight().norify(),
                                getRight().norify())));
    }

    @Override
    public Expression simplify() {
        if (getLeft().simplify().toString().equals("F") || getRight().simplify().toString().equals("F")) {
            return new Val(true);
        }
        if (getLeft().simplify().toString().equals("T") && getRight().simplify().toString().equals("T")) {
            return new Val(false);
        }
        if (getLeft().simplify().toString().equals("T")) {
            return new Not(getRight().simplify()).simplify();
        }
        if (getRight().simplify().toString().equals("T")) {
            return new Not(getLeft().simplify()).simplify();
        }
        if (getLeft().simplify().toString().equals(getRight().simplify().toString())) {
            return new Not(getLeft().simplify()).simplify();
        }
        return new Nand(getLeft().simplify(), getRight().simplify());
    }
}
