grammar gram;

TERMINATOR : '\n' | '\r' | '\r\n' | EOF;
WS : (' ' | '\t')+ -> skip;
NAME: [A-Z][A-Z0-9]*;

COMMA : ',' ;
TARGET : '|-' ;
MEANS : '->' ;
OR : '|' ;
AND : '&' ;
NOT : '!' ;
LPAREN : '(' ;
RPAREN : ')' ;

file : header TERMINATOR (rootExpression TERMINATOR)* ;
header : (expression (COMMA expression)*)? TARGET expression ;
rootExpression: expression;

expression : disj | (disj MEANS expression);
disj: conj | disj OR conj;
conj: neg | conj AND neg;
neg : NAME | NOT neg | LPAREN expression RPAREN;
