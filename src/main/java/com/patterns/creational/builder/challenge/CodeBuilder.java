package com.patterns.creational.builder.challenge;

public class CodeBuilder {
    private StringBuilder code;

    public CodeBuilder(String className) {
        code = new StringBuilder();
        code.append("public class ").append(className).append("\n{\n");
    }

    public CodeBuilder addField(String name, String type) {
        code.append("  public ").append(type).append(" ").append(name).append(";\n");
        return this;
    }

    @Override
    public String toString() {
        code.append("}");
        return code.toString();
    }

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}
