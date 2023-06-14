# Type Checker

## Developers

- Lars Lehmann ([@nichtLehdev](https://github.com/nichtLehdev))
- Yannick Kirschen ([@yannickkirschen](https://github.com/yannickkirschen))

## Usage

Construct an abstract ``Program`` and pass it to `TypeCheck.check`. The result
is a typed `Program`.

```java
Program program = new Program();
// Construct program here ...

Program typedProgram = TypeCheck.check(program);
// Do something with typedProgram ...
```

## Description

The code is located in the package `de.dhbw.compiler.typecheck`. The entry point
is the class `TypeCheck`. The class `TypeCheck` has a method `check` which
takes a `Program` as an argument and returns a typed `Program`. In case type
checking fails, either a `TypeException` or a `SyntaxException` is thrown.

There are five interfaces which are responsible for type checking:

- `BaseClassChecker`: Checks a class
- `BaseMethodChecker`: Checks a method
- `BaseStatementChecker`: Checks a statement
- `BaseExpressionChecker`: Checks an expression
- `BaseStatementExpressionChecker`: Checks a statement-expression

Their only implementations are the classes `ClassChecker`, `MethodChecker`,
`StatementChecker`, `ExpressionChecker` and `StatementExpressionChecker`.

All interfaces have a method `check` which takes the corresponding AST node as
an argument and returns a typed AST node. In case type checking fails, either a
`TypeException` or a `SyntaxException` is thrown.
