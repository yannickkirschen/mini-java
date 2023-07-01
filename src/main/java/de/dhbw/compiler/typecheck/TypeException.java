package de.dhbw.compiler.typecheck;

public class TypeException extends Exception {
    public TypeException(String message, Object... args) {
        super(message.formatted(args));
    }
}
