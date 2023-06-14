package de.dhbw.compiler.codegeneration;

import lombok.*;

@Getter
@AllArgsConstructor
public class ObjectType implements Type {
    private String name;

    public static ObjectType string() {
        return new ObjectType("java.lang.String");
    }
}
