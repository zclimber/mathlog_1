package com.company;

import com.company.grammar.gramBaseListener;
import com.company.grammar.gramParser;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGramListener extends gramBaseListener {

    private PrintStream out;

    public MyGramListener() {
        out = System.out;
    }

    public MyGramListener(PrintStream ps) {
        out = ps;
    }

    public static class ModusPonensContainer {
        public final String arule, brule, mover;
        public final int moverNum;
        public int anum;

        ModusPonensContainer(gramParser.ExpressionContext context, int num) {
            moverNum = num;
            mover = PrefixBuilder.stringify(context);
            arule = PrefixBuilder.stringify(context.disj());
            brule = PrefixBuilder.stringify(context.expression());
        }
    }

    private Map<String, Integer> facts = new HashMap<>(), givenFacts = new HashMap<>();

    private Map<String, ModusPonensContainer> aRuleRequiredMP = new HashMap<>(), possibleMP = new HashMap<>();

    public static final int ID_VAR_LENGTH = 1;
    public static final int ID_PREFIX_LENGTH = 1;
    public static final int ID_TOTAL_LENGTH = ID_PREFIX_LENGTH + ID_VAR_LENGTH;

    private int currentLine = 0;

    @Override
    public void exitHeader(gramParser.HeaderContext ctx) {
        List<gramParser.ExpressionContext> elist = ctx.expression();
        for (int i = 0; i < elist.size() - 1; i++) {
            givenFacts.put(PrefixBuilder.stringify(elist.get(i)), i + 1);
        }
        currentLine++;
    }

    @Override
    public void exitRootExpression(gramParser.RootExpressionContext ctx) {
        String prefixed;
        if (Util.getRootMeaningful(ctx) instanceof gramParser.ExpressionContext) {
            ModusPonensContainer mpc = new ModusPonensContainer((gramParser.ExpressionContext) Util.getRootMeaningful(ctx), currentLine);
            if (facts.containsKey(mpc.arule)) {
                mpc.anum = facts.get(mpc.arule);
                possibleMP.put(mpc.brule, mpc);
            } else {
                aRuleRequiredMP.put(mpc.arule, mpc);
            }
            prefixed = mpc.mover;
        } else {
            prefixed = PrefixBuilder.stringify(ctx.expression());
        }
        out.print("(" + Integer.toString(currentLine) + ")");
        out.print(ctx.getText());
        out.print("(");
        Integer axiomNumber = AxiomChecker.isAxiomUsage(prefixed);
        if (axiomNumber != null) {
            out.print("Сх. акс. " + axiomNumber.toString());
        } else if (givenFacts.containsKey(prefixed)) {
            out.print("Предп. " + givenFacts.get(prefixed).toString());
        } else if (possibleMP.containsKey(prefixed)) {
            ModusPonensContainer mpc = possibleMP.get(prefixed);
            out.print("M.P. " + Integer.toString(mpc.anum) + ", " + Integer.toString(mpc.moverNum));
        } else {
            out.print("Не доказано");
        }
        if (aRuleRequiredMP.containsKey(prefixed)) {
            ModusPonensContainer mpc = aRuleRequiredMP.get(prefixed);
            aRuleRequiredMP.remove(prefixed);
            mpc.anum = currentLine;
            possibleMP.put(mpc.brule, mpc);
        }
        facts.put(prefixed, currentLine);
//        System.out.print(")(" + prefixed);
        out.println(")");
        currentLine++;
    }
}
