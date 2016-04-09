package no.dv8.xhtml.generation.support;

import java.util.*;

public abstract class ElementBase<T extends ElementBase> implements Element<T> {

    String elementName;
    Map<Object, Object> attributes = new HashMap<>();
    List<Element<?>> children = new ArrayList<>();

    public ElementBase() {
        elementName = getClass().getSimpleName();
    }

    public ElementBase(String n) {
        this.elementName = n;
    }

    @Override
    public Map<Object, Object> getAttributes() {
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
