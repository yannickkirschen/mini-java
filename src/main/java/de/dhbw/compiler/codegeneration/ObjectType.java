package de.dhbw.compiler.codegeneration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ObjectType implements Type{
    private String name;
}
