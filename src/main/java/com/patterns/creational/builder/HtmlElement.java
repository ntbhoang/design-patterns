package com.patterns.creational.builder;

import java.util.ArrayList;

public class HtmlElement {
    public String name, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        String i = " ".repeat(indentSize * indent);
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if (text != null && !text.isEmpty()) {
            sb.append(" ".repeat(indentSize * (indent + 1)));
            sb.append(text);
            sb.append(newLine);
        }
        for (HtmlElement e : elements) {
            sb.append(e.toStringImpl(indent + 1));
        }
        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0) ;
    }

    class HtmlBuilder {
        private String rootName;
        private HtmlElement root = new HtmlElement();

        public HtmlBuilder(String rootName) {
            this.rootName = rootName;
            root.name = rootName;
        }

        public void addChild(String childName, String childText) {
            HtmlElement e = new HtmlElement(childName, childText);
            root.elements.add(e);
        }

        public void clear() {
            root = new HtmlElement();
            root.name = rootName;
        }

        @Override
        public String toString() {
            return root.toString();
        }
    }

    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlElement().new HtmlBuilder("ul");
        builder.addChild("li", "hello");
        builder.addChild("li", "world");
        System.out.println(builder);
    }
}
