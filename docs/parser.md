# Scanning & Parsing

## Developers

- Malte Richert ([@MalteRichert](https://github.com/MalteRichert))
- Liz Wellhausen ([@Lizzyhara](https://github.com/Lizzyhara))

## Usage

Receives a java file containing one or more classes and returns the corresponding untyped syntax tree.

```java
// Parse string to abstract syntax
String code = //some java code
Program p = Parser.parse(code);
// p holds a program object with nested classes
```

## Description
The code's logic is located in the package `de.dhbw.compiler.parser`, the AST model is located in the package `de.dhbw.compiler.ast`.
The entry point is the class `Parser`. It has a static method `parse` which
takes a string as an argument and generates an untyped abstract syntax tree.

The parsing logic uses ANTLR to parse the code into a `ParseTree` object structure.
That is passed to `AstGenerator` which uses the ANTLR-generated visitor pattern to build AST objects from the `parseTree`.
The implementation of ANTLR visitors is divided into `StatementGenerator` (for visiting Statements),
`ExpressionGenerator` for visiting Expressions and `StatementExpressionGenerator` for visiting StatementExpressions.

## Class Diagram
The UML class diagram describing the abstract syntax is located in this package as `UMLParser_realCode.drawio.png`.

## Testing
Scanning & Parsing can be tested via the unit tests in the package `test.java.de.dhbw-compiler.parser`.

## Notable features & design decisions
- Apart from the features described in the lecture, the scanner & parser component
supports parsing multiple classes.
- Multiple constructors can be declared but `this()` and `super()` calls are not supported.
- If no constructor is declared, a constructor with no parameters and empty body
is added by default.
- Comments (single-line as well as block) are supported
- Negative Integers and Expressions using unary minus are parsed as `Binary` with
`Integer(-a) == Binary(-,0,a)` and `Unary(-, a) == Binary(-,0,a)`.
- Assign statements with `LocalVarDecl` on the left (e.g. `int a = Expression`) are
parsed as a block containing first a `LocalVarDecl` and then an `Assign` statement
with the newly declared local variable on the left.
