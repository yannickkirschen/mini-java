grammar minijava;

program : class*;

class : 'class' id '{' (var | meth)* '}';

var : type id ';';
type : INT | BOOL | CHAR | STRING | VOID | refType;
refType : id;

meth : type id '(' params? ')' '{' stmt* '}';
params : param (',' param)*;
param : type id;

//TODO: implement var declaration and initialization in same line
stmt : '{' expr* '}'                            #Block
    | 'return' expr ';'                         #Return
    | 'while' '(' expr ')' stmt                 #While
    | var                                       #LocalVarDecl
    | 'if' '(' expr ')' stmt ('else' stmt)?     #If
    | stmtExpr                                  #StmtExprStmt
    ;

//TODO: implement unary operator statements (i++;), maybe as stmtExprs
expr : 'this'               #This
    | 'super'               #Super
    | id                    #Location
    | expr '.' id           #InstVar
    | unaryOpPre expr       #UnaryOperationPre
    | expr unaryOpPost      #UnaryOperationPost
    | expr binaryOp expr    #BinaryOperation
    | literal               #Constant
    | '\'' CHARACTER? '\''  #Character
    | '"' CHARACTER* '"'    #String
    | 'null'                #Null
    | '(' expr ')'          #Expression
    | stmtExpr              #StmtExprExpr
    ;

//TODO: iplement assignment to instVars (a.i = 1;) if required
stmtExpr : id '=' expr ';'                      #Assign
    | 'new' type '(' args? ')'                  #New
    | (id '.')? id '(' args? ')' ';'            #MethodCall
    ;

unaryOpPre : INCR | DECR | NOT | PLUS | MINUS;
unaryOpPost : INCR | DECR;
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
