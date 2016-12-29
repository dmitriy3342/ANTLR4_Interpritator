package SIB301.lib.scaner;

import SIB301.lib.*;
import SIB301.lib.atoms.*;
import SIB301.lib.context.EContext;
import SIB301.lib.expressions.*;
import SIB301.lib.expressions.array.EArray;
import SIB301.lib.expressions.array.EArrayGet;
import SIB301.lib.expressions.array.EArraySet;
import SIB301.lib.expressions.bool_expression.AEqualB;
import SIB301.lib.expressions.bool_expression.AGeaterB;
import SIB301.lib.expressions.bool_expression.ALessB;
import SIB301.lib.expressions.bool_expression.BooleanExpression;
import SIB301.lib.log.LogStats;

import java.util.ArrayList;
import java.util.List;


public class ExpressionVisitorImpl extends ExpressionBaseVisitor<Expression> {
    EContext<Expression> eContext = new EContext<>();

    String currenContextFunction = "";
    String currenContextClass = "";

    Integer index = 0;

    private List<String> inSycle = new ArrayList<>();

    boolean isSycle() {
        return inSycle.size() > 1;
    }

    String getContextSycle() {
        StringBuilder sb = new StringBuilder();

        for (int i = inSycle.size() - 1; i >= 0; i++) {
            sb.append(inSycle.get(i));
        }
        return getCurrenContext();
    }

    void addSycle(String context) {
        inSycle.add(context);
    }

    void dellSycle() {
        inSycle.remove(inSycle.size() - 1);
    }

    Integer getIndex() {
        return index++;
    }

    Boolean inBlock = false;

    void setCurrenContextFunction(String context) {
        currenContextFunction = context;
    }

    void setCurrenContextClass(String context) {
        currenContextClass = context;
    }

    void delCurrentContexFunction() {
        currenContextFunction = "";
    }

    void delCurrentContextClass() {
        currenContextClass = "";
    }

    String getCurrenContextClass() {
        if (!currenContextClass.isEmpty())
            return currenContextClass + ".";

        return "";
    }

    String getCurrenContext() {
        if (!currenContextClass.isEmpty() && !currenContextFunction.isEmpty())
            return currenContextClass + "." + currenContextFunction + ".";

        if (!currenContextClass.isEmpty())
            return currenContextClass + ".";

        if (!currenContextFunction.isEmpty())
            return currenContextFunction + ".";

        return "";
    }

    @Override
    public Expression visitStart(ExpressionParser.StartContext ctx) {
        return visit(ctx.exprBlock());
    }

    @Override
    public Expression visitExprBlock(ExpressionParser.ExprBlockContext ctx) {
        return super.visitExprBlock(ctx);
    }

    @Override
    public Expression visitExprLine(ExpressionParser.ExprLineContext ctx) {
        return super.visitExprLine(ctx);
    }


    @Override
    public Expression visitExpr(ExpressionParser.ExprContext ctx) {

//        if(ctx.cl != null)
//            visitExpr(ctx.nocl);
//        if(ctx.arrayCreate()!=null){
//            return visitArrayCreate(ctx.arrayCreate());
//        }

        if (ctx.startSubstring != null && ctx.finishSubstring != null) {
            LogStats.println("(visitExpr subString) ");
            Integer start = Integer.parseInt(ctx.startSubstring.getText());
            Integer finish = Integer.parseInt(ctx.finishSubstring.getText());
            return new Substring(visitExpr(ctx.str), start, finish);
        }

        if (ctx.op != null && ctx.left != null && ctx.right != null) {
            LogStats.println("(visitExpr op) ");
//            LogStats.println("OP : " + ctx.op.getText());
            String op = ctx.op.getText();

            Expression left = visit(ctx.left);
            Expression right = visit(ctx.right);

            if (left != null && right != null) {

//                LogStats.println("cleft : " + ctx.left.getText());
//                LogStats.println("cright : " + ctx.right.getText());

//                LogStats.println("left : " + left);
//                LogStats.println("right : " + right);

                switch (op.charAt(0)) {
                    case '*':
//                        LogStats.println('*');
                        return new Mul(left, right);
                    case '/':
//                        LogStats.println('/');
                        return new Del(left, right);
                    case '+':
//                        LogStats.println('+');
                        return new Plus(left, right);
                    case '-':
//                        LogStats.println('-');
                        return new Minus(left, right);
                    case '=':
//                        LogStats.println('-');
                        return new AEqualB(left, right);
                    case '<':
//                        LogStats.println('-');
                        return new ALessB(left, right);
                    case '>':
//                        LogStats.println('-');
                        return new AGeaterB(left, right);
                }
            }
        }

        if (ctx.exprCenter != null) {
            return visit(ctx.exprCenter);
        }

        if (ctx.inicialClass() != null)
            return visitInicialClass(ctx.inicialClass());

        if (ctx.initaialFunction() != null)
            return visitInitaialFunction(ctx.initaialFunction());

        if (ctx.objectAssignment() != null)
            return visitObjectAssignment(ctx.objectAssignment());

        if (ctx.callFunction() != null)
            return visitCallFunction(ctx.callFunction());


        if (ctx.objectValue() != null)
            return visitObjectValue(ctx.objectValue());

        return visitChildren(ctx);
    }


    @Override
    public Expression visitIdentificator(ExpressionParser.IdentificatorContext ctx) {
        return new Identifier(eContext, getCurrenContext() + ctx.getText());
    }

    //При инициализации переменной мы учитываем текущую область видимиости!
    @Override
    public Expression visitObjectAssignment(ExpressionParser.ObjectAssignmentContext ctx) {


        if (ctx.arrayCreate() != null) {
            return visitArrayCreate(ctx.arrayCreate());
        }


        if (ctx.identificator() != null) {
            Identifier identifier = (Identifier) visitIdentificator(ctx.identificator());
            Expression tmp = visit(ctx.expr());
            Assignment assignment = new Assignment(identifier,tmp);
//            identifier.putExpression(tmp);
            LogStats.println("(visitObjectAssignment) " + ctx.identificator().getText() + " = " + tmp + ";");
            if (getCurrenContext().isEmpty() && !isSycle()) assignment.interpreter();
            return assignment;
        }

        return defaultResult();//new Identifier(eContext);
    }

    @Override
    public Expression visitObjectValue(ExpressionParser.ObjectValueContext ctx) {
        if (ctx.identificator() != null) {
            return visitIdentificator(ctx.identificator());
        }

        return defaultResult();
    }

    @Override
    public Expression visitArrayGet(ExpressionParser.ArrayGetContext ctx) {
        LogStats.println("(visitArrayGet)" + getCurrenContext() + ctx.identificator().getText());
        EArray eArray = (EArray) eContext.findChild(getCurrenContext() + ctx.identificator().getText());

        return new EArrayGet(eArray, visit(ctx.expr()));
    }

    @Override
    public Expression visitArrayCreate(ExpressionParser.ArrayCreateContext ctx) {
        LogStats.println("(visitArrayCreate)" + getCurrenContext() + ctx.identificator().getText());
        EArray eArray = new EArray();
        for (ExpressionParser.ParamsContext param : ctx.params()) {
            eArray.add(visit(param).interpreter());
        }
        eContext.addChild(getCurrenContext() + ctx.identificator().getText(), eArray);
        return eArray;
    }

    @Override
    public Expression visitArrayAssignedItem(ExpressionParser.ArrayAssignedItemContext ctx) {
        LogStats.println("(visitArrayAssignedItem)" + getCurrenContext() + ctx.identificator().getText());

        EArray eArray = (EArray) eContext.findChild(getCurrenContext() + ctx.identificator().getText());

        EArraySet eArraySet =  new EArraySet(eArray, visit(ctx.index), visit(ctx.value));
        if (getCurrenContext().isEmpty() && !isSycle()) eArraySet.interpreter();
        return eArraySet;
    }

    @Override
    public Expression visitForel(ExpressionParser.ForelContext ctx) {
        addSycle(getCurrenContext() + getIndex());
        EBlock eBlock = new EBlock(eContext, getCurrenContext());


        for (ExpressionParser.ForelBodyContext context : ctx.forelBody()) {
            eBlock.addOperation(visit(context));
        }

        EForearch eForearch = new EForearch(visit(ctx.var), visit(ctx.vars), eBlock);

        if (getCurrenContext().isEmpty() && !isSycle()) eForearch.interpreter();

        dellSycle();
        return eForearch;
    }

    @Override
    public Expression visitWhileblock(ExpressionParser.WhileblockContext ctx) {
        LogStats.println("(visitIfalse) " + ctx.condition().getText());

        EWhile eWhile;
        EBlock eBlock = new EBlock(eContext, getCurrenContext() + getIndex());

        for (ExpressionParser.ExprContext context : ctx.expr()) {
            LogStats.println(getCurrenContext() + " add : " + context.getText());
            eBlock.addOperation(visitExpr(context));
        }


        eWhile = new EWhile((BooleanExpression) visitExpr(ctx.condition().expr()), eBlock);


        if (getCurrenContext().isEmpty()) eWhile.interpreter();

        return eWhile;
    }

    @Override
    public Expression visitInitaialFunction(ExpressionParser.InitaialFunctionContext ctx) {
        inBlock = true;
        LogStats.println("(visitInitaialFunction) " + getCurrenContext());
        LogStats.println("(visitInitaialFunction) " + ctx.identificator().getText());
        setCurrenContextFunction(ctx.functionName.getText());
        EFunction eFunction = new EFunction(eContext, getCurrenContextClass()+ ctx.identificator().getText());

        for (ExpressionParser.ParamsContext param : ctx.params()) {
            eFunction.addParam(param.identificator().getText());
        }

        for (ExpressionParser.ExprContext expr : ctx.expr()) {
            LogStats.println(getCurrenContext() + " add : " + expr.getText());
            eFunction.addOperation(visitExpr(expr));
        }

        for (ExpressionParser.IfalseContext ifalseContext : ctx.ifalse()) {
            LogStats.println(getCurrenContext() + " add : " + ifalseContext.getText());
            eFunction.addOperation(visitIfalse(ifalseContext));
        }
        for (ExpressionParser.ForelContext forelContext : ctx.forel()) {
            LogStats.println(getCurrenContext() + " add : " + forelContext.getText());
            eFunction.addOperation(visitForel(forelContext));
        }




        eFunction.setResult(visitExpr(ctx.myreturn().expr()));

        eContext.addChild(getCurrenContextClass()+ ctx.identificator().getText(), eFunction);
        delCurrentContexFunction();
        inBlock = false;
        return eFunction;
    }

    @Override
    public Expression visitCallFunction(ExpressionParser.CallFunctionContext ctx) {
        LogStats.println("(visitCallFunction) " + ctx.identificator().getText());

        EFunction eFunction = (EFunction) eContext.findChild(getCurrenContext()+ ctx.identificator().getText());

        List<Expression> expressions = new ArrayList<>();
        for (ExpressionParser.ParamsContext param : ctx.params()) {
            expressions.add(visitIdentificator(param.identificator()));
        }
        eFunction.setValuesParams(expressions);


        return eFunction.interpreter();
    }


    @Override
    public Expression visitInicialClass(ExpressionParser.InicialClassContext ctx) {
        EObject eObject = new EObject(ctx.className.getText());
        setCurrenContextClass(eObject.getContext());

        for (ExpressionParser.BodyClassContext bodyClassContext : ctx.bodyClass()) {
            if (bodyClassContext.initaialFunction() != null) {
                visitInitaialFunction(bodyClassContext.initaialFunction());
            }

            if (bodyClassContext.objectAssignment() != null) {
                visitObjectAssignment(bodyClassContext.objectAssignment()).interpreter();
            }

        }
        delCurrentContextClass();
        return eObject;
    }

    @Override
    public Expression visitGetElementWithClass(ExpressionParser.GetElementWithClassContext ctx) {

        return eContext.findChild(ctx.className.getText() + "::" + ctx.var.getText());
    }

    @Override
    public Expression visitCallMethod(ExpressionParser.CallMethodContext ctx) {
        EFunction eFunction = (EFunction) eContext.findChild(ctx.className.getText() + "::" + ctx.method.getText());


        List<Expression> expressions = new ArrayList<>();
        for (ExpressionParser.ParamsContext param : ctx.params()) {
            expressions.add(visitIdentificator(param.identificator()));
        }
        eFunction.setValuesParams(expressions);


        return eFunction.interpreter();
    }


    @Override
    public Expression visitBodyClass(ExpressionParser.BodyClassContext ctx) {
        return super.visitBodyClass(ctx);
    }

    @Override
    public Expression visitAtom(ExpressionParser.AtomContext ctx) {

        if (ctx.CHAR() != null) {
            EChar tmp = new EChar(ctx.getText().split("<<")[1].split(">>")[0].charAt(0));
            LogStats.println("(visitAtom) " + tmp.toString());
            return tmp;
        }

        if (ctx.NUMBER() != null) {
            EInt tmp = new EInt(Integer.parseInt(ctx.getText()));
            LogStats.println("(visitAtom) " + tmp.toString());
            return tmp;
        }
        if (ctx.STRING() != null) {
            EString tmp = new EString(ctx.getText().split("\"")[1]);
            LogStats.println("(visitAtom) " + tmp.toString());
            return tmp;
        }
        if (ctx.BOOLEAN() != null) {
            EBool tmp = new EBool(Boolean.parseBoolean(ctx.getText()));
            LogStats.println("(visitAtom) " + tmp.toString());
            return tmp;
        }


        return this.defaultResult();
    }

    @Override
    public Expression visitIfalse(ExpressionParser.IfalseContext ctx) {
        LogStats.println("(visitIfalse) " + ctx.condition().getText());
        inBlock = true;
        EIfElse ifElse;

        EBlock eBlockif = new EBlock(eContext, getCurrenContext() + getIndex());

        for (ExpressionParser.IfblockContext ifblockContext : ctx.ifblock()) {
            LogStats.println(getCurrenContext() + " add : " + ifblockContext.getText());
            eBlockif.addOperation(visitExpr(ifblockContext.expr()));
        }

        if (ctx.elseblock() != null) {
            EBlock eBlockElse = new EBlock(eContext, getCurrenContext() + getIndex());

            for (ExpressionParser.ElseblockContext blockContext : ctx.elseblock()) {
                LogStats.println(getCurrenContext() + " add : " + blockContext.getText());
                eBlockElse.addOperation(visitExpr(blockContext.expr()));
            }
            ifElse = new EIfElse((BooleanExpression) visitExpr(ctx.condition().expr()), eBlockif, eBlockElse);
        } else {
            ifElse = new EIfElse((BooleanExpression) visitExpr(ctx.condition().expr()), eBlockif);
        }

        if (getCurrenContext().isEmpty()) ifElse.interpreter();
        inBlock = false;
        return ifElse;
    }


    @Override
    public Expression visitPrint(ExpressionParser.PrintContext ctx) {

        LogStats.println("print( " + ctx.expr().getText() + " );");
        Expression ePrint;
        Expression tmp = visit(ctx.expr());

        if (tmp != null) {
            ePrint = new EPrint(tmp);
        } else {
            ePrint = new None();
        }
        if (!inBlock && getCurrenContext().isEmpty()) ePrint.interpreter();
        return ePrint;
    }


    @Override
    protected Expression defaultResult() {
        return new None();
    }

    protected Expression aggregateResult(Expression aggregate, Expression nextResult) {
        if (!(aggregate instanceof None) && aggregate != null)
            return aggregate;
        else return nextResult != null ? nextResult : new None();
    }


}
