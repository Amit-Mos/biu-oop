import java.util.List;
import java.util.Map;

public abstract class BaseExpression implements Expression {

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        throw new UnsupportedOperationException("Sorry, you are not allowed to use this object.");
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new UnsupportedOperationException("Sorry, you are not allowed to use this object.");
    }

    @Override
    public List<String> getVariables() {
        throw new UnsupportedOperationException("Sorry, you are not allowed to use this object.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Sorry, you are not allowed to use this object.");
    }

    @Override
    public Expression assign(String var, Expression expression) {
        throw new UnsupportedOperationException("Sorry, you are not allowed to use this object.");
    }
}
