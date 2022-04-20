import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Val implements Expression {
    private Boolean value;

    public Val(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (value != null) {
            return this.value;
        }
        throw new Exception("The value is null.");
    }

    @Override
    public Boolean evaluate() throws Exception {
        if (value != null) {
            return this.value;
        }
        throw new Exception("The value is null.");
    }

    @Override
    public List<String> getVariables() {
        return new LinkedList<String>();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if ((this.value && var.equals("T")) || (!this.value && var.equals("F"))) {
            return expression;
        }
        return new Val(this.value);
    }

    @Override
    public String toString() {
        if (this.value) {
            return "T";
        } else {
            return "F";
        }
    }

    public Expression nandify() {
        return new Val(this.value);
    }

    @Override
    public Expression norify() {
        return new Val(this.value);
    }

    @Override
    public Expression simplify() {
        return new Val(this.value);
    }
}
