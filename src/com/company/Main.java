package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.company.grammar.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.PredictionMode;

public class Main {

    private InputStream is;

    private PrintStream out;

    public Main(InputStream is, PrintStream out) {
        this.is = is;
        this.out = out;
    }

    public void parseAll() throws IOException {
        Lexer lexer = new gramLexer(CharStreams.fromStream(is));
        gramParser parser = new gramParser(new CommonTokenStream(lexer));
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
        parser.addParseListener(new MyGramListener(out));
        parser.file();
    }

    public static void main(String[] args) {
        InputStream is = null;
        PrintStream ps = null;
        String[] args2 = {"good6.in"};
        args = args2;
        if (args.length == 0) {
            System.err.println("Reading from stdin");
            is = System.in;
        } else {
            System.err.println("Reading from " + args[0]);
            try {
                is = Files.newInputStream(Paths.get(args[0]));
            } catch (IOException e) {
                System.err.println("Cannot read from " + args[0] + ":" + e.getMessage());
                System.exit(-1);
            }
        }
        if (args.length <= 1) {
            ps = System.out;
        } else {
            try {
                ps = new PrintStream(Files.newOutputStream(Paths.get(args[1])));
            } catch (IOException e) {
                System.err.println("Cannot write to " + args[1] + ":" + e.getMessage());
                System.exit(-1);
            }
        }
        try {
            new Main(is, ps).parseAll();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
