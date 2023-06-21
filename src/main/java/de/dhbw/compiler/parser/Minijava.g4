grammar Minijava;

program : class*;

class : 'class' type '{' (varDecl ';' | meth | constructor)* '}';

varDecl : type Id;
type : Int | Bool | Char | String | Void | refType;
refType : Id;

meth : type Id '(' params? ')' block;
params : param (',' param)*;
param : type Id;

constructor : refType '(' params? ')' '{' subConstructor? stmt* '}';
subConstructor : ('this' | 'super') '(' args? ')' ';';

//Statements
block : '{' stmt* '}';
return : 'return' expr ';';
while : 'while' '(' expr ')' stmt;
localVarDeclAssign : varDecl '=' expr ';';
if : 'if' '(' expr ')' stmt ('else' stmt)?; //TODO: limit condition to bools

stmt : block
    | return
    | while
    | localVarDeclAssign
    | varDecl
    | if
    | stmtExpr ';'
    ;

//Expressions
instVar : This '.' Id | (This '.')? (Id '.')+ Id;
This : 'this';
Super : 'super';
localOrFieldVar : Id;
unaryOperation : unaryOp expr;
binaryOperation : subExpression binaryOp expr; //TODO: add operator priorities
constant : Number | Boolean;
char : '\'' Character? '\'';
string : '"' Character* '"';
Null : 'null';
expression : '(' expr ')';


expr : subExpression | binaryOperation;
// introduce subExpression to avoid left-recursion
subExpression : This
    | Super
    | localOrFieldVar
    | instVar
    | unaryOperation
    | constant
    | char
    | string
    | Null
    | expression
    | stmtExpr
    ;

//StatementExpressions
unaryAssign : assignable unaryAssOp | unaryAssOp assignable;
new: 'new' type '(' args? ')';
methodCall : (localOrFieldVar '.')? Id '(' args? ')';
assign : assignable '=' expr;
assignable : Id | instVar;

stmtExpr : unaryAssign
    | assign
    | new
    | methodCall
    ;


unaryAssOp : Incr | Decr;
unaryOp : Not | Plus | Minus;
binaryOp : binCalcOp | binBoolOp;

binCalcOp : Plus | Minus | Mul | Div | Mod;
binBoolOp : Equal | NotEqual | Greater | GreaterOrEqual | Less | LessOrEqual | And | Or;

args : expr (',' expr)*;


//Literals
Incr : '++';
Decr : '--';
Not : '!';
Plus : '+';
Minus : '-';

Mul : '*';
Div : '/';
Mod : '%';

Equal : '==';
NotEqual : '!=';
Greater : '>';
GreaterOrEqual : '>=';
Less : '<';
LessOrEqual : '<=';
Or : '||';
And : '&&';

Int : 'int';
Bool : 'boolean';
Char : 'char';
String : 'String';
Void : 'void';
Boolean : 'true' | 'false' ;

Id : [a-zA-Z]+;
Number : [0-9]+;
Character : [a-zA-Z0-9];


WS : [ \t\r\n] -> skip;
Comment:'//' ~[\r\n]* -> skip;
BlockComment: '/*' .*? '*/' -> skip;
