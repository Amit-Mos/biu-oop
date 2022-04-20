import java.util.List;

public abstract class BinaryExpression extends BaseExpression {
    protected Expression left;
    protected Expression right;
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
}
