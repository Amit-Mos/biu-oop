import java.util.Map;

/**
 * The Not class represents the mathematical operator Not.
 */
public class Not extends UnaryExpression {
    /**
     * Creates a new Not object.
     * @param itself the expression inside the Not expression.
     */
    public Not(Expression itself) {
        super.setItself(itself);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (this.getItself() == null) {
            throw new Exception("The expression is null, can't evaluate the expression.");
        }
        if (this.getItself().evaluate(assignment) == null) {
            throw new Exception("The expression value is null, can't evaluate the expression.");
        }
        return !this.getItself().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        if (this.getItself() == null) {
            throw new Exception("The expression is null, can't evaluate the expression.");
        }
        if (this.getItself().evaluate() == null) {
            throw new Exception("The expression value is null, can't evaluate the expression.");
        }
        return !this.getItself().evaluate();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(this.getItself().assign(var, expression));
    }

    @Override
    public String toString() {
        return "~(" + this.getItself().toString() + ")";
    }

    @Override
    public Expression nandify() {
        return new Nand(
                getItself().nandify(),
                getItself().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(
                getItself().norify(),
                getItself().norify());
    }

    @Override
    public Expression simplify() {
        if (getItself().simplify().toString().equals("T")) {
            return new Val(false);
        }
        if (getItself().simplify().toString().equals("F")) {
            return new Val(true);
        }
        return new Not(getItself().simplify());
    }
}
