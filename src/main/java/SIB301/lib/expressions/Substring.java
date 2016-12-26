package SIB301.lib.expressions;

import SIB301.lib.atoms.EString;

public class Substring extends Expression {
    Expression expression;
    Integer start;
    Integer finish;

    public Substring(Expression expression, Integer start, Integer finish) {
        this.expression = expression;
        this.start = start;
        this.finish = finish;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    @Override
    public Expression interpreter() {
        if(expression instanceof EString)
            return ((EString) expression).substring(start,finish);
        return new Substring(expression.interpreter(),start,finish).interpreter();
    }
}
