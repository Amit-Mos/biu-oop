import java.util.List;

public abstract class UnaryExpression extends BaseExpression {
    protected Expression itself;
    @Override
    public List<String> getVariables() {
        return this.itself.getVariables();
    }
}
