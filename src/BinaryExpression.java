import java.util.List;
/**
 * A class for a general binary Expression.
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression left;
    private Expression right;
    protected Expression getLeft() {
        return left;
    }

    protected Expression getRight() {
        return right;
    }

    protected void setLeft(Expression left) {
        this.left = left;
    }

    protected void setRight(Expression right) {
        this.right = right;
    }

    @Override
    public List<String> getVariables() {
        List<String> leftList = left.getVariables();
        List<String> rightList = right.getVariables();
        for (String str : rightList) {
            if (!leftList.contains(str)) {
                leftList.add(str);
            }
        }
        return leftList;
    }
}