package SIB301.lib.expressions;

import SIB301.lib.atoms.None;
import SIB301.table_ids.TableIDsWithScope;

public class Identifier extends Expression {

    TableIDsWithScope<Expression> table;
    String identifier;

    public Identifier(TableIDsWithScope<Expression> table, String identifier) {
        this.table = table;
        this.identifier = identifier;
    }

    public void putExpression(Expression expression) {
        table.put(identifier, expression);
    }

    public Expression getExpression() {
        return table.get(identifier) != null ? table.get(identifier) : new None();
    }

    @Override
    public Expression interpreter() {
        return getExpression().interpreter();
    }
}
