package de.dhbw.compiler.ast;

import lombok.*;

@Getter
@AllArgsConstructor
public class ObjectType implements Type {
    private String name;

    public static ObjectType string() {
        return new ObjectType("java/lang/String");
    }
    public static ObjectType object() {
        return new ObjectType("java/lang/Object");
    }
    public static ObjectType jNull() {
        return new ObjectType("null");
    }


}
