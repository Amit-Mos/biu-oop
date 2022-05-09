import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The Val class represents true or false value.
 */
public class Val implements Expression {
    private Boolean value;

    /**
     * Creates a new Val object.
     * @param value the value of the Val, true or false.
     */
    public Val(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (this.value == null) {
            throw new Exception("Can't return null value, should be true or false.");
        }
        return this.value;
    }
    @Override
    public Boolean evaluate() throws Exception {
        if (this.value == null) {
            throw new Exception("Can't return null value, should be true or false.");
        }
        return this.value;
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
        }
        return "F";
    }
    @Override
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
