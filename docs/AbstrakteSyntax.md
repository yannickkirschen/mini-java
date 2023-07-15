# Abstrakte Syntax

Class(
  "UnitTests",
  [],
  [
    Method(
      Type("void"),
      "testParseTree",
      [
        Param(Type("String"), "in"),
        Param(Type("String"), "expected")
      ],
      Block([
        LocalVarDecl(
          Type("CharStream"),
          "input",
          MethodCall(
            Type("CharStreams"),
            "fromString",
            [
              LocalOrFieldVar("in")
            ]
          )
        ),
        LocalVarDecl(
          Type("MinijavaLexer"),
          "lexer",
          New(
            Type("MinijavaLexer"),
            [
              LocalOrFieldVar("input")
            ]
          )
        ),
        LocalVarDecl(
          Type("CommonTokenStream"),
          "tokens",
          New(
            Type("CommonTokenStream"),
            [
              LocalOrFieldVar("lexer")
            ]
          )
        ),
        LocalVarDecl(
          Type("MinijavaParser"),
          "parser",
          New(
            Type("MinijavaParser"),
            [
              LocalOrFieldVar("tokens")
            ]
          )
        ),
        LocalVarDecl(
          Type("MinijavaParser.ProgramContext"),
          "tree",
          MethodCall(
            LocalOrFieldVar("parser"),
            "program",
            []
          )
        ),
        LocalVarDecl(
          Type("Program"),
          "out",
          MethodCall(
            Type("ASTGenerator"),
            "generateAST",
            [
              LocalOrFieldVar("tree")
            ]
          )
        ),
        LocalVarDecl(
          Type("String"),
          "outString",
          MethodCall(
            MethodCall(
              MethodCall(
                LocalOrFieldVar("out"),
                "classes",
                []
              ),
              "get",
              [
                Integer(0)
              ]
            ),
            "toString",
            []
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              LocalOrFieldVar("expected"),
              LocalOrFieldVar("outString")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "BinaryTestOK",
      [],
      Block([
        LocalVarDecl(
          Type("Binary", []),
          "i",
          New(
            Type("Binary", []),
            [
              String("+"),
              New(
                Type("JInteger", []),
                [
                  String("5"),
                  Type("PrimitiveType", ["INTEGER"])
                ]
              ),
              New(
                Type("JInteger", []),
                [
                  String("-2"),
                  Type("PrimitiveType", ["INTEGER"])
                ]
              ),
              Type("PrimitiveType", ["INTEGER"])
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              String("+"),
              MethodCall(
                LocalOrFieldVar("i"),
                "operator",
                []
              )
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              Type("PrimitiveType", []),
              MethodCall(
                MethodCall(
                  LocalOrFieldVar("i"),
                  "left",
                  []
                ),
                "getType",
                []
              )
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              String("5"),
              MethodCall(
                Cast(
                  Type("JInteger", []),
                  MethodCall(
                    LocalOrFieldVar("i"),
                    "left",
                    []
                  )
                ),
                "value",
                []
              )
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              Type("PrimitiveType", []),
              MethodCall(
                MethodCall(
                  LocalOrFieldVar("i"),
                  "right",
                  []
                ),
                "getType",
                []
              )
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              String("-2"),
              MethodCall(
                Cast(
                  Type("JInteger", []),
                  MethodCall(
                    LocalOrFieldVar("i"),
                    "right",
                    []
                  )
                ),
                "value",
                []
              )
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "BinaryTestMixOK",
      [],
      Block([
        LocalVarDecl(
          Type("Binary", []),
          "i",
          New(
            Type("Binary", []),
            [
              String("-"),
              New(
                Type("JBoolean", []),
                [
                  String("true"),
                  Type("PrimitiveType", ["BOOLEAN"])
                ]
              ),
              New(
                Type("JInteger", []),
                [
                  String("-2"),
                  Type("PrimitiveType", ["INTEGER"])
                ]
              ),
              Type("PrimitiveType", ["INTEGER"])
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              String("-"),
              MethodCall(
                LocalOrFieldVar("i"),
                "operator",
                []
              )
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              Type("PrimitiveType", []),
              MethodCall(
                MethodCall(
                  LocalOrFieldVar("i"),
                  "left",
                  []
                ),
                "getType",
                []
              )
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              String("true"),
              MethodCall(
                Cast(
                  Type("JBoolean", []),
                  MethodCall(
                    LocalOrFieldVar("i"),
                    "left",
                    []
                  )
                ),
                "value",
                []
              )
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              Type("PrimitiveType", []),
              MethodCall(
                MethodCall(
                  LocalOrFieldVar("i"),
                  "right",
                  []
                ),
                "getType",
                []
              )
            ]
          )
        ),
        StmtExprStmt(
          MethodCall(
            This,
            "assertEquals",
            [
              String("-2"),
              MethodCall(
                Cast(
                  Type("JInteger", []),
                  MethodCall(
                    LocalOrFieldVar("i"),
                    "right",
                    []
                  )
                ),
                "value",
                []
              )
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "EmptyClass",
      [],
      Block([
        TryCatch(
          Block([
            StmtExprStmt(
              MethodCall(
                This,
                "testParseTree",
                [
                  String("class Leer { }"),
                  String("Leer\nLeer()\nBlock()")
                ]
              )
            )
          ]),
          "Exception",
          Block([
            StmtExprStmt(
              MethodCall(
                This,
                "fail",
                [
                  String("Leere Klasse Fall 1 fehlgeschlagen")
                ]
              )
            )
          ])
        ),
        TryCatch(
          Block([
            StmtExprStmt(
              MethodCall(
                This,
                "testParseTree",
                [
                  String("class Leer { Leer( ){  } }"),
                  String("Leer\nLeer()\nBlock()")
                ]
              )
            )
          ]),
          "Exception",
          Block([
            StmtExprStmt(
              MethodCall(
                This,
                "fail",
                [
                  String("Leere Klasse Fall 2 fehlgeschlagen")
                ]
              )
            )
          ])
        )
      ])
    ),
    Method(
      Type("void"),
      "EmptyMethod",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { boolean boomethod() { }}"),
              String("Leer\nLeer()\nBlock()\nboolean\sboomethod()\nBlock()")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "Binary",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { void boomethod(){ int x = 1; x = x / x; }}"),
              String("Leer\nLeer()\nBlock()\nvoid\sboomethod()\nBlock(Block(LocalVarDeclint(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JInteger:1))Block(irgendwas zur Rechnung?!))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "Boolean",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { boolean boomethod(){ boolean x = true; }}"),
              String("Leer\nLeer()\nBlock()\nboolean\sboomethod()\nBlock(Block(LocalVarDeclboolean(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JBoolean:true)))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "InstVar",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer  {boolean x; boolean boomethod(){ this.x }}"),
              String("Leer\nboolean x\nLeer()\nBlock()\nboolean boomethod()\nBlock(irgendwas mit der kack variable)")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "Character",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer  {void boomethod(){ char x = 'x'; }}"),
              String("Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclchar(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JCharacter:x)))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "Integer",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer  {void boomethod(){ int x = 1; }}"),
              String("Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclint(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JInteger:1)))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "String",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer  {void boomethod(){ string x = \"null\"; }}"),
              String("Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclstring(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JString:null)))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "Null",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer  {void boomethod(){ string x = null; }}"),
              String("Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclstring(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=JNull:)))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "LocalOrFieldVar",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer  {void boomethod(){ int y; int x; x = y; }}"),
              String("Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalOrFieldVar + irgendwas mit assign schlag mich tot))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "Unary",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer  {void boomethod(){ boolean x = !true; }}"),
              String("Leer\nLeer()\nBlock()\nvoid boomethod()\nBlock(Block(LocalVarDeclboolean(Name: x)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:x=Unary:JBoolean:true!)))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "If",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { int x; boolean boomethod(){ if(true) {int a = 1;} else { int z = -99;}}}"),
              String("Leer\n" +
            "int x\n" +
            "Leer()\n" +
            "Block()\n" +
            "boolean boomethod()\n" +
            "Block(If(Expression: JBoolean:trueif body: Block(Block(LocalVarDeclint(Name: a)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:a=JInteger:1)))else body: Block(Block(LocalVarDeclint(Name: z)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:z=Unary:JInteger:99-)))))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "Return",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { int boomethod(){ return 25 }}"),
              String("Leer\n" +
            "Leer()\n" +
            "Block()\n" +
            "int boomethod()\n" +
            "Block(Return(Expression: JInteger:25))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "While",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { void boomethod(){ while( true == false ){ return true; } }}"),
              String("Leer\n" +
            "Leer()\n" +
            "Block()\n" +
            "void boomethod()\n" +
            "????????????")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "MethodCall",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { void boomethod(){ boomethod(); }}"),
              String("Leer\n" +
            "Leer()\n" +
            "Block()\n" +
            "void boomethod()\n" +
            "????????????")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "New",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { Leer(){} void boomethod(){ Leer empty = new Leer(); } }"),
              String("Leer\n" +
            "Leer()\n" +
            "Block()\n" +
            "void boomethod()\n" +
            "????????????")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "SimpleClass",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { int x; Leer(int x){ int i = x; } boolean boomethod(){ if(true) {return false;} else { return true;}}}"),
              String("Leer\nint x\nLeer(int x )\nBlock(Block(LocalVarDeclint(Name: i)StmtExprStmt(StatementExpression: Assign:LocalOrFieldVar:i=LocalOrFieldVar:x)))\nboolean boomethod()\nBlock(If(Expression: JBoolean:trueif body: Block(Return(Expression: JBoolean:false))else body: Block(Return(Expression: JBoolean:true))))")
            ]
          )
        )
      ])
    ),
    Method(
      Type("void"),
      "CallOwnConstructor",
      [],
      Block([
        StmtExprStmt(
          MethodCall(
            This,
            "testParseTree",
            [
              String("class Leer { int x; Leer(int x){ int i = x; } boolean boomethod( ){ if(true) {return false;} else { return true;} Leer blah = new Leer(); int i = blah.x;}}"),
              String("Leer\nint x\nLeer(int x )\n\nboolean boomethod()\n")
            ]
          )
        )
      ])
    )
  ]
)
