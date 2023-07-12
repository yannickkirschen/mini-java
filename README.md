# Mini Java

[![Lint commit message](https://github.com/yannickkirschen/mini-java/actions/workflows/commit-lint.yml/badge.svg)](https://github.com/yannickkirschen/mini-java/actions/workflows/commit-lint.yml)
[![Package](https://github.com/yannickkirschen/mini-java/actions/workflows/maven-package.yml/badge.svg)](https://github.com/yannickkirschen/mini-java/actions/workflows/maven-package.yml)
[![GitHub release](https://img.shields.io/github/release/yannickkirschen/mini-java.svg)](https://github.com/yannickkirschen/mini-java/releases/)

---
## Info - Code Generation

### General
The code generation is build around the visitor pattern. \
Each node of the Typed Abstract Syntax Tree (TAST) is visited once and the corresponding opcodes are put into the respective class- / method-writer.
For detailed information on how each node is translated to jvm-opcodes, please refer to the javadocs inside `MethodCodeVisitor.java` and `CodeGenVisitor.java`.

### Testing - Code Generation
The code generation can be tested independently from the rest of the project with `TestCodeGeneration.java`. \
Inside the class the motivated tester will find a main as well as various testcases, testing each expression, statement and statement expression.  \
To execute a testcase, line 20 `clazzes.add({methodName})` has to be altered by inserting the methodname of the correspondig testcase. \
Above each testcase inside the javadoc the javacode that is generated by the corresponding testcase is written (obviously in a human-readable form :) ). \
Validating that the generated `.class` file actually is properly compiled javacode can be done in two ways:
1. using the intelliJ integrated decompiler (which under the hood is the fernFlower decompiler)
2. creating a testing-class that has a `public static void main`, which creates an object of the class we want to test and calls the respective methods. <br/>
such a testing-class could look like this (tests the testCase `getterSetter()`):
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