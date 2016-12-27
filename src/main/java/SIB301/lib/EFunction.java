package SIB301.lib;

import SIB301.lib.atoms.None;
import SIB301.lib.context.EContext;
import SIB301.lib.expressions.Expression;
import SIB301.lib.expressions.Identifier;


import java.util.ArrayList;
import java.util.List;



public class EFunction extends Expression {

    List<Identifier> params;
    List<Expression> operations;
    String context;
    EContext<Expression> eContext;

    public Expression getResult() {
        return result;
    }

    public void setResult(Expression result) {
        this.result = result;
    }

    Expression result;

    //Массив параметров в ввиде набора идентификаторов



    public EFunction(EContext<Expression> eContext, String context, List<Expression> operations, Expression result, List<Identifier> params) {
        this.result = result;
        this.eContext = eContext;
        this.context = context;
        this.params = params;
        this.operations = operations;
    }

    public EFunction(EContext<Expression> eContext, String context, List<Expression> operations, Expression result) {
        this(eContext, context, operations, result, new ArrayList<>());
    }

    public EFunction(EContext<Expression> eContext, String context) {
        this(eContext, context, new ArrayList<>(), new None());
    }

    public List<Identifier> getParams() {
        return params;
    }

    public void addParam( String name) {
        Identifier identifier = new Identifier(eContext, getContext() +'.' + name);
        this.params.add(identifier);
    }

    public void addOperation(Expression expression) {
        this.operations.add(expression);
    }

    public void add(Expression expression) {
        this.operations.add(expression);
    }

    public void setValuesParams(List<Expression> params) {
        for (int i = 0; i < params.size(); i++) {
            eContext.addChild(this.params.get(i).getIdentifier(),params.get(i));
        }
    }

    public List<Expression> getOperations() {
        return operations;
    }

    public void setOperations(List<Expression> operations) {
        this.operations = operations;
    }


    public String getContext(){
        if(!context.isEmpty())
            return context ;
        else return context;
    }

    @Override
    public Expression interpreter() {
        for (Expression expr :
                operations) {
            expr.interpreter();
        }
        return result;
    }
}
