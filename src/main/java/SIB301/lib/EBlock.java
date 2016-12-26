package SIB301.lib;

import SIB301.lib.atoms.None;
import SIB301.lib.expressions.Expression;
import SIB301.lib.expressions.Identifier;
import SIB301.table_ids.TableIDsWithScope;

import java.util.ArrayList;
import java.util.List;

public class EBlock extends Expression{
    List<Expression> operations;
    String context;
    TableIDsWithScope<Expression> table;


    public EBlock(TableIDsWithScope<Expression> table, String context, List<Expression> operations) {
        this.table = table;
        this.context = context;
        this.operations = operations;
    }


    public EBlock(TableIDsWithScope<Expression> table, String context) {
        this(table, context, new ArrayList<>());
    }

    public void addOperation(Expression expression) {
        this.operations.add(expression);
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
        return new None();
    }
}
