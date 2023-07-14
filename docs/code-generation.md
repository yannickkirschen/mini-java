# Code Generation

## Developers

- Benjamin Frahm ([@Rex2002](https://github.com/Rex2002))
- Moritz Thoma ([@mrtz4thm](https://github.com/mrtz4thm))

## Usage

Receives a typed `Program` and generates an executable .class File.

```java
// Parse typed program into generateCode() method
CodeGenerator.generateCode(p);
// corresponding ProgramName.class will be appear in projekt root directory
```

## Description

The code is located in the package `de.dhbw.compiler.codegeneration`. The entry
point
is the class `CodeGenerator`. The class `CodeGenerator` has a
method `generateCode` which
takes a typed `Program` as an argument and generates an executable .class file.

The generation logic is implemented using the Visitor-Pattern.
The class `CodeGenVisitor` initializes the `ClassWriter` and iterates through all
fields, constructors and methods and calls each visitor instruction.
The implementation of each visitor method is located in `MethodCodeVisitor`.
For managing local variables and checking `LocalOrFieldVar` being a field we use the `LocalVarStack`.
In order to implement an easy way for type checking we spitted `Type` into `PrimitivType` and `ObjectType`.
