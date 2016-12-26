// Generated from D:/Учёба/4 Курс/СПО/lab_4/src/main/java/SIB301\Expression.g4 by ANTLR 4.5.3
package SIB301.lib.scaner;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExpressionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#exprBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBlock(ExpressionParser.ExprBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#exprLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLine(ExpressionParser.ExprLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExpressionParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ExpressionParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#objectAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectAssignment(ExpressionParser.ObjectAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#objectValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectValue(ExpressionParser.ObjectValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#initaialFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitaialFunction(ExpressionParser.InitaialFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#myreturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyreturn(ExpressionParser.MyreturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#callFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFunction(ExpressionParser.CallFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(ExpressionParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#ifalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfalse(ExpressionParser.IfalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#ifblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfblock(ExpressionParser.IfblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#elseblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseblock(ExpressionParser.ElseblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ExpressionParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#arrayGet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayGet(ExpressionParser.ArrayGetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#arrayCreate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreate(ExpressionParser.ArrayCreateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#arrayAssignedItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignedItem(ExpressionParser.ArrayAssignedItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#forel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForel(ExpressionParser.ForelContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#forelBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForelBody(ExpressionParser.ForelBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#whileblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileblock(ExpressionParser.WhileblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#inicialClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicialClass(ExpressionParser.InicialClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#bodyClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyClass(ExpressionParser.BodyClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#getElementWithClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetElementWithClass(ExpressionParser.GetElementWithClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#callMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallMethod(ExpressionParser.CallMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#identificator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificator(ExpressionParser.IdentificatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ExpressionParser.AtomContext ctx);
}