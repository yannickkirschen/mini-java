package de.dhbw.compiler.typecheck;

public class SyntaxException extends Exception {
    public SyntaxException(String message, Object... args) {
        super(message.formatted(args));
    }
}
