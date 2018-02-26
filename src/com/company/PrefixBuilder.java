package com.company;

import com.company.grammar.gramBaseListener;
import com.company.grammar.gramParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;
import java.util.Map;

import static com.company.Util.getIdFromNumber;

class PrefixBuilder extends gramBaseListener {
    public final StringBuilder sb = new StringBuilder();
    private final Map<String, String> nameMap;
    private String variableNamePrefix = "A";
    private int variableCount = 0;

    public PrefixBuilder() {
        nameMap = new HashMap<>();
    }

    public PrefixBuilder(Map<String, String> smap) {
        nameMap = smap;
    }

    @Override
    public void enterExpression(gramParser.ExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            sb.append(">");
        }
    }

    @Override
    public void enterDisj(gramParser.DisjContext ctx) {
        if (ctx.getChildCount() == 3) {
            sb.append("|");
        }
    }

    @Override
    public void enterConj(gramParser.ConjContext ctx) {
        if (ctx.getChildCount() == 3) {
            sb.append("&");
        }
    }

    @Override
    public void enterNeg(gramParser.NegContext ctx) {
        if (ctx.getChildCount() == 1) {
            String extId = ctx.NAME().getText();
            if (!nameMap.containsKey(extId)) {
                nameMap.put(extId, getIdFromNumber(variableCount, MyGramListener.ID_VAR_LENGTH));
                variableCount++;
            }
            sb.append(variableNamePrefix);
            sb.append(nameMap.get(extId));
        } else if (ctx.getChildCount() == 2) {
            sb.append("!");
        }
    }

    public static String stringify(ParserRuleContext context) {
        PrefixBuilder pb = new PrefixBuilder();
        ParseTreeWalker.DEFAULT.walk(pb, context);
        return pb.sb.toString();
    }
}
