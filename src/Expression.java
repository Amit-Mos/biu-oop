import java.util.List;
import java.util.Map;

public interface Expression {
    /**
     * Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     * @param assignment the variable values.
     * @return the result of the expression.
     * @throws Exception in case the expression contains a variable which is not in the assignment or null.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * @return the result of the expression.
     * @throws Exception in case the expression contains a variable which is not known.
     */
    Boolean evaluate() throws Exception;

    /**
     * Helps up find the variables involved in the expression.
     * @return a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * Converts out expression to a nice string.
     * @return a nice string representation of the expression.
     */
    String toString();

    /**
     * Helps up modify our expression and changes it in a new expression.
     * @param var the var we want to replace.
     * @param expression the expression to replace the Var with.
     * @return a new expression in which all occurrences of the variable var are replaced with the provided expression
     * (Does not modify the current expression).
     */
    Expression assign(String var, Expression expression);

    /**
     * Converts a normal expression to an expression expressed by the logical Nand operation.
     * @return the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    Expression nandify();

    /**
     * Converts a normal expression to an expression expressed by the logical Nor operation.
     * @return the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    Expression norify();

    /**
     * Makes long and complex expression shorter and simple.
     * @return a simplified version of the current expression.
     */
    Expression simplify();
}
