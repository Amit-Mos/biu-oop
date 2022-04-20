import java.util.List;
import java.util.Map;

public class And implements Expression {
    private Expression left;
    private Expression right;

    public And(Expression left, Expression right) {
        this.left = left;
        this.right = right;
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
        return left.evaluate(assignment) && right.evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        if (left == null || right == null) {
            throw new Exception("The left value or the right value is null.");
        }
        if (left.evaluate() == null || right.evaluate() == null) {
            throw new Exception("The left evaluation value or the right evaluation value is null.");
        }
        return left.evaluate() && right.evaluate();
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
        Expression eLeft = this.left.assign(var, expression);
        Expression eRight = this.right.assign(var, expression);
        return new And(eLeft, eRight);
    }

    @Override
    public String toString() {
        return "(" + this.left.toString() + " & " + this.right.toString() + ")";
    }

    public Expression nandify() {
        return new Nand(
                new Nand(left.nandify(), right.nandify()),
                new Nand(left.nandify(), right.nandify()));
    }

    @Override
    public Expression norify() {
        return new Nor(
                new Nor(left.norify(), left.norify()),
                new Nor(right.norify(), right.norify()));
    }

    @Override
    public Expression simplify() {
        if (left.simplify().toString().equals("F") || right.simplify().toString().equals("F")) {
            return new Val(false);
        }
        if (left.simplify().toString().equals("T")) {
            return right.simplify();
        }
        if (right.simplify().toString().equals("T")) {
            return left.simplify();
        }
        if (left.simplify().toString().equals((right.simplify().toString()))) {
            return left.simplify();
        }
        return new And(left.simplify(), right.simplify());
    }
}
