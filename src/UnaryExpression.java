import java.util.List;
/**
 * A class for a general unary Expression.
 */
public abstract class UnaryExpression extends BaseExpression {
    private Expression itself;
    protected Expression getItself() {
        return itself;
    }

    protected void setItself(Expression itself) {
        this.itself = itself;
    }

    @Override
    public List<String> getVariables() {
        return this.itself.getVariables();
    }
}
