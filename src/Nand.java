import java.util.List;
import java.util.Map;

public class Nand extends BinaryExpression {

    public Nand(Expression left, Expression right) {
        super.left = left;
        super.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (left == null || right == null) {
            throw new Exception("The left value or the right value is null.");
        }
        if (left.evaluate(assignment) == null || right.evaluate(assignment) == null) {
            throw new Exception("The left evaluation value or the right evaluation value is null.");
        }
        return !(left.evaluate(assignment) && right.evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        if (left == null || right == null) {
            throw new Exception("The left value or the right value is null.");
        }
        if (left.evaluate() == null || right.evaluate() == null) {
            throw new Exception("The left evaluation value or the right evaluation value is null.");
        }
        return !(left.evaluate() && right.evaluate());
    }

    @Override
    public List<String> getVariables() {
        List<String> leftList = left.getVariables();
        List<String> rightList = right.getVariables();
        for (String str : rightList) {
            if (!leftList.contains(str)){
                leftList.add(str);
            }
        }
        return leftList;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression eLeft = left.assign(var, expression);
        Expression eRight = right.assign(var, expression);
        return new Nand(eLeft, eRight);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " A " + right.toString() + ")";
    }

    @Override
    public Expression nandify() {
        return new Nand(left, right);
    }

    @Override
    public Expression norify() {
        return new Nor(
                new Nor(
                        new Nor(left.norify(), left.norify()),
                        new Nor(right.norify(), right.norify())),
                new Nor(
                        new Nor(left.norify(), left.norify()),
                        new Nor(right.norify(), right.norify())));
    }


    @Override
    public Expression simplify() {
        if (left.simplify().toString().equals("T")) {
            return new Not(right.simplify());
        }
        if (right.simplify().toString().equals("T")) {
            return new Not(left.simplify());
        }
        if (left.simplify().toString().equals("F") || right.simplify().toString().equals("F")) {
            return new Val(true);
        }
        if (left.simplify().toString().equals(right.simplify().toString())) {
            return new Not(left.simplify());
        }
        return new Nand(left.simplify(), right.simplify());
    }
}
