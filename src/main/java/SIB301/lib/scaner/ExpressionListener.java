// Generated from D:/Учёба/4 Курс/СПО/lab_4/src/main/java/SIB301\Expression.g4 by ANTLR 4.5.3
package SIB301.lib.scaner;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExpressionParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExpressionParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#exprBlock}.
	 * @param ctx the parse tree
	 */
	void enterExprBlock(ExpressionParser.ExprBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#exprBlock}.
	 * @param ctx the parse tree
	 */
	void exitExprBlock(ExpressionParser.ExprBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#exprLine}.
	 * @param ctx the parse tree
	 */
	void enterExprLine(ExpressionParser.ExprLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#exprLine}.
	 * @param ctx the parse tree
	 */
	void exitExprLine(ExpressionParser.ExprLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExpressionParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExpressionParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ExpressionParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ExpressionParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#objectAssignment}.
	 * @param ctx the parse tree
	 */
	void enterObjectAssignment(ExpressionParser.ObjectAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#objectAssignment}.
	 * @param ctx the parse tree
	 */
	void exitObjectAssignment(ExpressionParser.ObjectAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#objectValue}.
	 * @param ctx the parse tree
	 */
	void enterObjectValue(ExpressionParser.ObjectValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#objectValue}.
	 * @param ctx the parse tree
	 */
	void exitObjectValue(ExpressionParser.ObjectValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#initaialFunction}.
	 * @param ctx the parse tree
	 */
	void enterInitaialFunction(ExpressionParser.InitaialFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#initaialFunction}.
	 * @param ctx the parse tree
	 */
	void exitInitaialFunction(ExpressionParser.InitaialFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#myreturn}.
	 * @param ctx the parse tree
	 */
	void enterMyreturn(ExpressionParser.MyreturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#myreturn}.
	 * @param ctx the parse tree
	 */
	void exitMyreturn(ExpressionParser.MyreturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void enterCallFunction(ExpressionParser.CallFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void exitCallFunction(ExpressionParser.CallFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(ExpressionParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(ExpressionParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#ifalse}.
	 * @param ctx the parse tree
	 */
	void enterIfalse(ExpressionParser.IfalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#ifalse}.
	 * @param ctx the parse tree
	 */
	void exitIfalse(ExpressionParser.IfalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#ifblock}.
	 * @param ctx the parse tree
	 */
	void enterIfblock(ExpressionParser.IfblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#ifblock}.
	 * @param ctx the parse tree
	 */
	void exitIfblock(ExpressionParser.IfblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#elseblock}.
	 * @param ctx the parse tree
	 */
	void enterElseblock(ExpressionParser.ElseblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#elseblock}.
	 * @param ctx the parse tree
	 */
	void exitElseblock(ExpressionParser.ElseblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ExpressionParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ExpressionParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#arrayGet}.
	 * @param ctx the parse tree
	 */
	void enterArrayGet(ExpressionParser.ArrayGetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#arrayGet}.
	 * @param ctx the parse tree
	 */
	void exitArrayGet(ExpressionParser.ArrayGetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#arrayCreate}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreate(ExpressionParser.ArrayCreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#arrayCreate}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreate(ExpressionParser.ArrayCreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#arrayAssignedItem}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignedItem(ExpressionParser.ArrayAssignedItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#arrayAssignedItem}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignedItem(ExpressionParser.ArrayAssignedItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#forel}.
	 * @param ctx the parse tree
	 */
	void enterForel(ExpressionParser.ForelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#forel}.
	 * @param ctx the parse tree
	 */
	void exitForel(ExpressionParser.ForelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#forelBody}.
	 * @param ctx the parse tree
	 */
	void enterForelBody(ExpressionParser.ForelBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#forelBody}.
	 * @param ctx the parse tree
	 */
	void exitForelBody(ExpressionParser.ForelBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#whileblock}.
	 * @param ctx the parse tree
	 */
	void enterWhileblock(ExpressionParser.WhileblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#whileblock}.
	 * @param ctx the parse tree
	 */
	void exitWhileblock(ExpressionParser.WhileblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#inicialClass}.
	 * @param ctx the parse tree
	 */
	void enterInicialClass(ExpressionParser.InicialClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#inicialClass}.
	 * @param ctx the parse tree
	 */
	void exitInicialClass(ExpressionParser.InicialClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#bodyClass}.
	 * @param ctx the parse tree
	 */
	void enterBodyClass(ExpressionParser.BodyClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#bodyClass}.
	 * @param ctx the parse tree
	 */
	void exitBodyClass(ExpressionParser.BodyClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#getElementWithClass}.
	 * @param ctx the parse tree
	 */
	void enterGetElementWithClass(ExpressionParser.GetElementWithClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#getElementWithClass}.
	 * @param ctx the parse tree
	 */
	void exitGetElementWithClass(ExpressionParser.GetElementWithClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#callMethod}.
	 * @param ctx the parse tree
	 */
	void enterCallMethod(ExpressionParser.CallMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#callMethod}.
	 * @param ctx the parse tree
	 */
	void exitCallMethod(ExpressionParser.CallMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#identificator}.
	 * @param ctx the parse tree
	 */
	void enterIdentificator(ExpressionParser.IdentificatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#identificator}.
	 * @param ctx the parse tree
	 */
	void exitIdentificator(ExpressionParser.IdentificatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ExpressionParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ExpressionParser.AtomContext ctx);
}