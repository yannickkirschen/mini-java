package de.dhbw.compiler.parser;

import de.dhbw.compiler.ast.*;
import de.dhbw.compiler.ast.statements.Block;
import de.dhbw.compiler.ast.statements.Statement;
import de.dhbw.compiler.parser.antlr.MinijavaParser;

import java.util.ArrayList;
import java.util.List;

public class ASTGenerator {
    public static Program generateAST(MinijavaParser.ProgramContext parseTree) {
        List<Clazz> classes = new ArrayList<>();
        for(MinijavaParser.ClassContext clsCtx : parseTree.class_()){
            classes.add(generateClazz(clsCtx));
        }

        return new Program(classes);
    }

    private static Clazz generateClazz(MinijavaParser.ClassContext ctx) {
        MinijavaParser.TypeContext  tyCtx = ctx.type();
        AstType name = generateType(tyCtx);

        List<Field> fields = new ArrayList<>();
        for(MinijavaParser.VarDeclContext varCtx : ctx.varDecl()){
            fields.add(generateField(varCtx));
        }

        List<Constructor> constructors = new ArrayList<>();
        if (ctx.constructor() != null && ctx.constructor().size() > 0) {
            for (MinijavaParser.ConstructorContext constCtx : ctx.constructor()) {
                constructors.add(generateConstructor(constCtx));
            }
        } else {
            constructors.add(new Constructor(
                new ArrayList<>(),
                new Block( new ArrayList<>() )
            ) );
        }

        List<Method> meths = new ArrayList<>();
        for(MinijavaParser.MethContext methCtx : ctx.meth()){
            meths.add(generateMeth(methCtx));
        }

        return new Clazz(name, fields, constructors, meths);
    }

    private static Constructor generateConstructor(MinijavaParser.ConstructorContext ctx) {
        List<Parameter> parameters = ctx.params() != null ? generateParams(ctx.params()) : new ArrayList<>();

        StatementGenerator sGen = new StatementGenerator();
        Statement stmt = sGen.visit( ctx.block() );

        return new Constructor(parameters, stmt);
    }

    public static AstType generateType(MinijavaParser.TypeContext ctx) {
        if(ctx.Int() != null)
            return new AstType(ctx.Int().getText());
        if(ctx.Bool() != null)
            return new AstType(ctx.Bool().getText());
        if(ctx.Char() != null)
            return new AstType(ctx.Char().getText());
        if(ctx.String() != null)
            return new AstType(ctx.String().getText());
        if(ctx.Void() != null)
            return new AstType(ctx.Void().getText());
        if(ctx.refType() != null)
            return new AstType(ctx.refType().Id().getSymbol().getText());
        throw new RuntimeException();
    }

    private static Field generateField(MinijavaParser.VarDeclContext ctx) {
        AstType type = generateType(ctx.type());
        String name = ctx.Id().getSymbol().getText();

        return new Field(type, name);
    }

    private static Method generateMeth(MinijavaParser.MethContext ctx) {
        AstType returnType = generateType(ctx.type());
        String name = ctx.Id().getSymbol().getText();
        List<Parameter> parameters = ctx.params() != null ? generateParams(ctx.params()) : new ArrayList<>();

        StatementGenerator sGen = new StatementGenerator();
        Statement stmt = sGen.visit( ctx.block() );

        return new Method(returnType, name, parameters, stmt);
    }

    private static List<Parameter> generateParams(MinijavaParser.ParamsContext ctx) {
        List<Parameter> params = new ArrayList<>();
        for (MinijavaParser.ParamContext paramCtx : ctx.param()) {
            AstType type = generateType(paramCtx.type());
            String name = paramCtx.Id().getSymbol().getText();
            params.add( new Parameter(type, name) );
        }

        return params;
    }
}
