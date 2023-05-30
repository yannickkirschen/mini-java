package de.dhbw.compiler.codegeneration;

import java.util.HashMap;

public class MethodVarStack {

    private HashMap<String, Integer> varStack = new HashMap<>();
    private int varStackPointer = 0;

    public void addVar(String name){
        varStack.put(name, varStackPointer);
        varStackPointer++;
    }

    public int getVar(String name){
        return varStack.get(name);
    }

    public String getVarName(int id){
        // TODO
        // but may not be necessary
        return "";
    }

    public boolean contains(String varName){
        return varStack.containsKey(varName);
    }

    public int getIndex(String varName){
        if(varStack.containsKey(varName)){
            return varStack.get(varName);
        }
        return -1;

    }

}
