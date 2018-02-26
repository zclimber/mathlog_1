package com.company;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class Util {
    public static final int poolSize = 26 * 2 + 10;

    private static char getchar(int number) {
        if (number < 0 || number >= poolSize) {
            throw new IllegalArgumentException();
        }
        if (number < 26) {
            return (char) ('a' + number);
        } else if (number < 26 * 2) {
            return (char) ('A' + number - 26);
        } else {
            return (char) ('0' + number - 26 * 2);
        }
    }

    public static String getIdFromNumber(int number, int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(getchar(number % poolSize));
            number /= poolSize;
        }
        return sb.toString();
    }

    public static ParserRuleContext getRootMeaningful(ParserRuleContext ctx) {
        int ruleContextCount = 0;
        ParserRuleContext child = null;
        for (ParseTree cand : ctx.children) {
            if (cand instanceof ParserRuleContext) {
                child = (ParserRuleContext) cand;
                ruleContextCount++;
            }
        }
        if (ruleContextCount == 1) {
            return getRootMeaningful(child);
        } else {
            return ctx;
        }
    }
}
