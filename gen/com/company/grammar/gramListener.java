// Generated from C:/Users/MY/IdeaProjects/mathlog_1/src\gram.g4 by ANTLR 4.7
package com.company.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramParser}.
 */
public interface gramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(gramParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(gramParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(gramParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(gramParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void enterRootExpression(gramParser.RootExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void exitRootExpression(gramParser.RootExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(gramParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(gramParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#disj}.
	 * @param ctx the parse tree
	 */
	void enterDisj(gramParser.DisjContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#disj}.
	 * @param ctx the parse tree
	 */
	void exitDisj(gramParser.DisjContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#conj}.
	 * @param ctx the parse tree
	 */
	void enterConj(gramParser.ConjContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#conj}.
	 * @param ctx the parse tree
	 */
	void exitConj(gramParser.ConjContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(gramParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(gramParser.NegContext ctx);
}