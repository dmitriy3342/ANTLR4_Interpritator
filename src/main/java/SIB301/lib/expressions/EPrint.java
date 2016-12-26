package SIB301.lib.expressions;

/**
 * Created by dmitr on 26.12.2016.
 */
public class EPrint extends Expression{
    Expression expression;

    public EPrint(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Expression interpreter() {
        System.out.println(expression.interpreter().toString());
        return super.interpreter();
    }
}
