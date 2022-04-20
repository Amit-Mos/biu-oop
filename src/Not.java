import java.util.List;
import java.util.Map;

public class Not extends UnaryExpression {

    public Not(Expression itself) {
        super.itself = itself;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (this.itself == null) {
            throw new Exception("The expression is null.");
        }
        if (this.itself.evaluate(assignment) == null) {
            throw new Exception("The evaluation value is null.");
        }
        return !this.itself.evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        if (this.itself == null) {
            throw new Exception("The expression is null.");
        }
        if (this.itself.evaluate() == null) {
            throw new Exception("The evaluation value is null.");
        }
        return !this.itself.evaluate();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(this.itself.assign(var, expression));
    }

    @Override
    public String toString() {
        return "~(" + this.itself.toString() + ")";
    }

    @Override
    public Expression nandify() {
        return new Nand(itself.nandify(), itself.nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(itself.norify(), itself.norify());
    }

    @Override
    public Expression simplify() {
        return new Not(itself.simplify());
    }
}
