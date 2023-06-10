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

    private static Clazz generateClazz(MinijavaParser.ClassContext clsCtx) {
        MinijavaParser.TypeContext  tyCtx = clsCtx.type();
        Type name = generateType(tyCtx);

        List<Field> fields = new ArrayList<>();
        for(MinijavaParser.VarContext varCtx : clsCtx.var()){
            fields.add(generateField(varCtx));
        }

        List<Constructor> constructors = new ArrayList<>();
        if (clsCtx.const_() != null && clsCtx.const_().size() > 0) {
            for (MinijavaParser.ConstContext constCtx : clsCtx.const_()) {
                constructors.add(generateConstructor(constCtx));
            }
        } else {
            constructors.add(new Constructor(
                new ArrayList<>(),
                new Block( new ArrayList<>() )
            ) );
        }


        List<Method> meths = new ArrayList<>();
        for(MinijavaParser.MethContext methCtx : clsCtx.meth()){
            meths.add(generateMeth(methCtx));
        }

        return new Clazz(name, fields, constructors, meths);
    }

    private static Constructor generateConstructor(MinijavaParser.ConstContext constCtx) {
        List<Parameter> parameters = generateParams(constCtx.params());

        StatementGenerator sGen = new StatementGenerator();
        Statement stmt = sGen.visit( constCtx.block() );

        return new Constructor(parameters, stmt);
    }

    public static Type generateType(MinijavaParser.TypeContext tyContext) {
        if(tyContext.INT() != null)
            return new Type(tyContext.INT().getText());
        if(tyContext.BOOL() != null)
            return new Type(tyContext.BOOL().getText());
        if(tyContext.CHAR() != null)
            return new Type(tyContext.CHAR().getText());
        if(tyContext.STRING() != null)
            return new Type(tyContext.STRING().getText());
        if(tyContext.VOID() != null)
            return new Type(tyContext.VOID().getText());
        if(tyContext.refType() != null)
            return new Type(generateId(tyContext.refType().id()));
        throw new RuntimeException();
    }

    public static String generateId(MinijavaParser.IdContext idCtx) {
        return idCtx.IDENTIFIER().getText();
    }

    private static Field generateField(MinijavaParser.VarContext varCtx) {
        Type type = generateType(varCtx.type());
        String name = generateId(varCtx.id());

        return new Field(type, name);
    }

    private static Method generateMeth(MinijavaParser.MethContext methCtx) {
        Type returnType = generateType(methCtx.type());
        String name = generateId(methCtx.id());
        List<Parameter> parameters = generateParams(methCtx.params());

        StatementGenerator sGen = new StatementGenerator();
        Statement stmt = sGen.visit( methCtx.block() );

        return new Method(returnType, name, parameters, stmt);
    }

    private static List<Parameter> generateParams(MinijavaParser.ParamsContext paramsCtx) {
        List<Parameter> params = new ArrayList<>();
        for (MinijavaParser.ParamContext paramCtx : paramsCtx.param()) {
            Type type = generateType(paramCtx.type());
            String name = generateId(paramCtx.id());
            params.add( new Parameter(type, name) );
        }

        return params;
    }
}
