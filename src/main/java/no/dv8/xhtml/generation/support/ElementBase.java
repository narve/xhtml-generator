package no.dv8.xhtml.generation.support;

import java.util.*;

public class ElementBase<T extends ElementBase> implements Element<T> {

    String elementName;
    Map<String, String> attributes = new HashMap<>();
    List<Element<?>> children = new ArrayList<>();

    public ElementBase() {
        elementName = getClass().getSimpleName();
    }

    public ElementBase(String n) {
        this.elementName = n;
    }

    @Override
    public Map<String, String> getAttributes() {
        return attributes;
    }

    @Override
    public List<Element<?>> getChildren() {
        return children;
    }

    @Override
    public String name() {
        return elementName;
    }

    @Override
    public String toString() {
        return toHTML();
    }

}
