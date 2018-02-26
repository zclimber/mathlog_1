package com.company;

import com.company.grammar.gramLexer;
import com.company.grammar.gramParser;
import com.sun.istack.internal.Nullable;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class AxiomChecker {

    private static final String[] axiomsBase = {"(ϕ)→((ψ)→(ϕ))", "((ϕ)→(ψ))→((ϕ)→(ψ)→(π))→((ϕ)→(π))",
            "(ϕ)→(ψ)→(ϕ)&(ψ)", "(ϕ)&(ψ)→(ϕ)", "(ϕ)&(ψ)→(ψ)", "(ϕ)→(ϕ)∨(ψ)", "(ψ)→(ϕ)∨(ψ)",
            "((ϕ)→(π))→((ψ)→(π))→((ϕ)∨(ψ)→(π))", "((ϕ)→(ψ))→((ϕ)→¬(ψ))→¬(ϕ)", "¬¬(ϕ)→(ϕ)"};
    private static final String[] axiomsPrefix;

    static {
        axiomsPrefix = new String[axiomsBase.length];
        for (int i = 0; i < axiomsBase.length; i++) {
            String axiom = axiomsBase[i]
                    .replace('ϕ', 'A')
                    .replace('ψ', 'B')
                    .replace('π', 'C')
                    .replace('¬', '!')
                    .replace('∨', '|')
                    .replace("→", "->");
            gramParser parser = new gramParser(new CommonTokenStream(new gramLexer(CharStreams.fromString(axiom))));
            gramParser.ExpressionContext ctx = parser.expression();

            axiomsPrefix[i] = PrefixBuilder.stringify(ctx)
                    .replaceAll("Aa", "a")
                    .replaceAll("Ab", "b")
                    .replaceAll("Ac", "c");
        }
    }

    private static String getExprSubstring(String original, int offset) {
        int depth = 1;
        int boffs = offset;
        while (depth > 0) {
            switch (original.charAt(boffs)) {
                case 'A':
                    depth--;
                    boffs += MyGramListener.ID_TOTAL_LENGTH;
                    break;
                case '!':
                    boffs++;
                    break;
                case '>':
                case '|':
                case '&':
                    depth++;
                    boffs++;
                    break;
                default:
                    throw new RuntimeException("WTF " + original);
            }
        }
        return original.substring(offset, boffs);
    }

    private static boolean isAxiom(String prefixedExpression, String prefixedAxiom) {
//        System.err.println(prefixedExpression + " ? " + prefixedAxiom);
        int ePos = 0, aPos = 0;
        String modFiles[] = new String[3];
        while (aPos < prefixedAxiom.length()) {
            if (ePos >= prefixedExpression.length()) {
                return false;
            }
            int ps = 0;
            switch (prefixedAxiom.charAt(aPos)) {
                case 'a':
                case 'b':
                case 'c':
                    ps = prefixedAxiom.charAt(aPos) - 'a';
                    if (modFiles[ps] == null) {
                        modFiles[ps] = getExprSubstring(prefixedExpression, ePos);
                    } else {
                        if (!prefixedExpression.startsWith(modFiles[ps], ePos)) {
                            return false;
                        }
                    }
                    ePos += modFiles[ps].length();
                    aPos++;
                    break;
                default:
                    if (prefixedExpression.charAt(ePos) != prefixedAxiom.charAt(aPos)) {
                        return false;
                    }
                    ePos++;
                    aPos++;
            }
        }
        return true;
    }

    @Nullable
    public static Integer isAxiomUsage(String prefixedExpression) {
        for (int i = 0; i < axiomsPrefix.length; i++) {
            if (isAxiom(prefixedExpression, axiomsPrefix[i])) {
                return i + 1;
            }
        }
        return null;
    }
}
