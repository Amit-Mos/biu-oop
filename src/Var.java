import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Var implements Expression {
    private String key;

    public Var(String key) {
        this.key = key;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (key == null) {
            throw new Exception("The key is null.");
        }
        if (assignment.containsKey(key)) {
            return assignment.get(key);
        }
        throw new Exception("The map does not contain a value with " + key + " as a key.");
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("Can not evaluate the expression without the right map.");
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new LinkedList<String>();
        list.add(this.key);
        return list;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (var.equals(this.key)) {
            return expression;
        }
        return new Var(this.key);
    }

    @Override
    public String toString() {
        return this.key;
    }

    public Expression nandify() {
        return new Var(this.key);
    }

    @Override
    public Expression norify() {
        return new Var(this.key);
    }

    @Override
    public Expression simplify() {
        return new Var(this.key);
    }
}
