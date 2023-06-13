grammar Minijava;

program : class*;

class : 'class' type '{' (var | meth | const)* '}';

var : type id ';';
type : INT | BOOL | CHAR | STRING | VOID | refType;
refType : id;

meth : type id '(' params? ')' block;
params : param (',' param)*;
param : type id;

const : refType '(' params? ')' block;

//TODO: implement var declaration and initialization in same line
stmt : block                                    #BlockStmt
    | 'return' expr ';'                         #Return
    | 'while' '(' expr ')' stmt                 #While
    | var                                       #LocalVarDecl
    | 'if' '(' expr ')' stmt ('else' stmt)?     #If
    | stmtExpr ';'                              #StmtExprStmt
    ;

block : '{' stmt* '}';

expr : 'this'               #This
    | 'super'               #Super
    | location              #LocationExpr
    | expr '.' id           #InstVar
    | unaryOp expr          #UnaryOperation
    | expr binaryOp expr    #BinaryOperation
    | literal               #Constant
    | '\'' CHARACTER? '\''  #Character
    | '"' CHARACTER* '"'    #String
    | 'null'                #Null
    | '(' expr ')'          #Expression
    | stmtExpr              #StmtExprExpr
    ;

location : id;

//TODO: iplement assignment to instVars (a.i = 1;) if required
stmtExpr : id unaryAssOp                        #UnaryAssignPost
    | unaryAssOp id                             #UnaryAssignPre
    | id '=' expr                               #Assign
    | 'new' type '(' args? ')'                  #New
    | (location '.')? id '(' args? ')'          #MethodCall
    ;

unaryAssOp : INCR | DECR;
unaryOp : NOT | PLUS | MINUS;
binaryOp : PLUS | MINUS | MUL;

args : expr (',' expr)*;

literal : number | boolean;

boolean : 'true' | 'false' ;

number : Number;
id : IDENTIFIER;

INCR : '++';
DECR : '--';
NOT : '!';
PLUS : '+';
MINUS : '-';

MUL : '*';
DIV : '/';

INT : 'int';
BOOL : 'boolean';
CHAR : 'char';
STRING : 'String';
VOID : 'void';

IDENTIFIER : [a-zA-Z]+;
Number : [0-9]+;
CHARACTER : [a-zA-Z0-9];
WS : [ \t\r\n] -> skip;
