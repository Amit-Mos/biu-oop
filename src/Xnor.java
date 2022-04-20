import java.util.List;
import java.util.Map;

public class Xnor implements Expression {
    private Expression left;
    private Expression right;

    public Xnor(Expression left, Expression right) {
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
        return !((!left.evaluate(assignment) && right.evaluate(assignment))
                || (left.evaluate(assignment) && !right.evaluate(assignment)));
    }

    @Override
    public Boolean evaluate() throws Exception {
        if (left == null || right == null) {
            throw new Exception("The left value or the right value is null.");
        }
        if (left.evaluate() == null || right.evaluate() == null) {
            throw new Exception("The left evaluation value or the right evaluation value is null.");
        }
        return !((!left.evaluate() && right.evaluate()) || (left.evaluate() && !right.evaluate()));
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
        return new Xnor(eLeft, eRight);
    }

    @Override
    public String toString() {
        return "(" + this.left.toString() + " # " + this.right.toString() + ")";
    }


    @Override
    public Expression nandify() {
        return new Nand(
                new Nand(
                        new Nand(left.norify(), left.norify()),
                        new Nand(right.norify(), right.norify())),
                new Nand(left.norify(), right.norify()));
    }

    @Override
    public Expression norify() {
        return new Nor(
                new Nor(left.nandify(),
                        new Nor(left.nandify(), right.nandify())),
                new Nor(right.nandify(),
                        new Nor(left.nandify(), right.nandify())));
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