grammar Crux;
program
 : declList EOF
 ;

declList
 : decl*
 ;

decl
 : varDecl
 | arrayDecl
 | functionDefn
 ;

varDecl
 : type Identifier ';'
 ;

type
 : Identifier
 ;

literal
 : Integer
 | True
 | False
 ;


designator
 : Identifier (OpenBracket expr0 CloseBracket )?
 ;

op0
 : GreaterEqual | LesserEqual | NotEqual | Equal | GreaterThan | LessThan
 ;

op1
 : Add | Sub | Or
 ;

op2
 : Mul | Div | And
 ;

expr0
 : expr1 (op0 expr1 )?
 ;

expr1
 : expr2
 | expr1 op1 expr2
 ;

expr2
 : expr3
 | expr2 op2 expr3
 ;
expr3
 : Not expr3
 | OpenParen expr0 CloseParen
 | designator
 | callExpr
 | literal
 ;

callExpr
 : Identifier OpenParen exprList CloseParen
 ;

exprList
 : (expr0 (Comma expr0 )* )?
 ;

param
 : type Identifier
 ;
paramList
 : (param (Comma param)* )?
 ;

arrayDecl
 : type Identifier OpenBracket Integer CloseBracket SemiColon
 ;
functionDefn
 : type Identifier OpenParen paramList CloseParen stmtBlock
 ;

assignStmt
 : designator Assign expr0 SemiColon
 ;

assignStmtNoSemi
 : designator Assign expr0
 ;

callStmt
 : callExpr SemiColon
 ;

ifStmt //WRITTEN IN DISC
 : If expr0 stmtBlock (Else stmtBlock )?
 ;

forStmt
 : For OpenParen assignStmt expr0 SemiColon assignStmtNoSemi CloseParen stmtBlock
 ;

breakStmt
 : Break SemiColon
 ;

returnStmt
 : Return expr0 SemiColon
 ;

stmt
 : varDecl
 | callStmt
 | assignStmt
 | ifStmt
 | forStmt
 | breakStmt
 | returnStmt
 ;

stmtList
 : stmt*
 ;

stmtBlock
 : OpenBrace stmtList CloseBrace
 ;

And: '&&' ;

Or: '||' ;

Not: '!' ;

If: 'if' ;

Else: 'else' ;

For: 'for' ;

Break: 'break' ;

SemiColon: ';';

Return: 'return' ;

OpenParen: '(' ;

CloseParen: ')' ;

OpenBracket: '[' ;

CloseBracket: ']' ;

OpenBrace: '{' ;

CloseBrace: '}' ;

Add: '+' ;

Sub: '-';

Mul: '*' ;

Div: '/' ;

GreaterEqual: '>=';

LesserEqual: '<=' ;

NotEqual: '!=' ;

Equal: '==';

GreaterThan: '>' ;

LessThan: '<';

Assign: '=';

Comma: ',';

Integer
 : '0'
 | [1-9] [0-9]*
 ;

True: 'true';
False: 'false';

Identifier
 : [a-zA-Z] [a-zA-Z0-9_]*
 ;

WhiteSpaces
 : [ \t\r\n]+ -> skip
 ;

Comment
 : '//' ~[\r\n]* -> skip
 ;


