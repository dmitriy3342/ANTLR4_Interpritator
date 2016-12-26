package SIB301.lib;

import SIB301.lib.atoms.None;
import SIB301.lib.expressions.Expression;
import SIB301.lib.expressions.Identifier;
import SIB301.table_ids.TableIDs;
import SIB301.table_ids.TableIDsWithScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EFunction extends Expression {

    List<Identifier> params;
    List<Expression> operations;
    String context;
    TableIDsWithScope<Expression> table;

    public Expression getResult() {
        return result;
    }

    public void setResult(Expression result) {
        this.result = result;
    }

    Expression result;

    //Массив параметров в ввиде набора идентификаторов



    public EFunction(TableIDsWithScope<Expression> table, String context, List<Expression> operations, Expression result, List<Identifier> params) {
        this.result = result;
        this.table = table;
        this.context = context;
        this.params = params;
        this.operations = operations;
    }

    public EFunction(TableIDsWithScope<Expression> table, String context, List<Expression> operations, Expression result) {
        this(table, context, operations, result, new ArrayList<>());
    }

    public EFunction(TableIDsWithScope<Expression> table, String context) {
        this(table, context, new ArrayList<>(), new None());
    }

    public List<Identifier> getParams() {
        return params;
    }

    public void addParam( String name) {
        Identifier identifier = new Identifier(table, getContext() + name);
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
            this.params.get(i).putExpression(params.get(i).interpreter());
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
