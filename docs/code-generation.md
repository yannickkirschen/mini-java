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
For detailed information on how each node of the TAST (typed abstract syntax tree) is translated to jvm-opcodes, please refer to the javadocs inside `MethodCodeVisitor.java` and `CodeGenVisitor.java`.


## Testing - Code Generation
The code generation can be tested independently of the rest of the project with `TestCodeGeneration.java`. \
Inside the class the motivated tester will find a main as well as various testcases, testing each expression, statement and statement expression.  \
To execute a testcase, line 20 `clazzes.add({methodName})` has to be altered by inserting the methodname of the correspondig testcase. \
Above each testcase inside the javadoc the javacode that is generated by the corresponding testcase is written (obviously in a human-readable form :) ). \
It is possible to add multiple classes to the clazzes-ArrayList, but one would have to go to the method and change the classnames to avoid name-conflicts, since most of the generated classes are called "TestClass".
Validating that the generated `.class` file actually is properly compiled javacode can be done in two ways:
1. using the intelliJ integrated decompiler (which under the hood is the fernFlower decompiler)
2. creating a testing-class that has a `public static void main`, which creates an object of the class we want to test and calls the respective methods. <br/>
   Such a testing-class could look like this (tests the testCase `getterSetter()`):
    ```
    public class TestGetterSetter {
        public static void main(String[] args){
            TestClass tc = new TestClass();
            System.out.println("Getting: " + tc.getVar());
            tc.setVar(10);
            System.out.println("After Setting: " + tc.getVar());
        }
    }
    ```
   The `.java` classfile has to be saved inside the same directory as the generated `.class` resides and has to be compiled using java8.
