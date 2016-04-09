package no.dv8.xhtml.generation.support;

import no.dv8.xhtml.generation.attributes.*;
import no.dv8.xhtml.generation.attributes.collections.MicroData;
import no.dv8.xhtml.generation.attributes.collections.RDFALite;

import java.io.StringWriter;
import java.util.*;

public interface Element<T extends Element> extends Id<T>, Clz<T>, MicroData<T>, RDFALite<T> {

    String EOL = "\r\n";
    // If this is changed, Escaping must be updated!!
    char ATTR_QUOTE = '\'';
    int COL_BREAK_LIMIT = 50;

    String name();

    List<Element<?>> getChildren();

    @SuppressWarnings("unchecked")
    default T self() {
        return (T) this;
    }

    default T add(Element<?> a) {
        getChildren().add(a);
        return self();
    }

    default T add(Collection<? extends Element<?>> a) {
        getChildren().addAll(a);
        return self();
    }

    default T add(String s) {
        return add(new Str(s));
    }

    default boolean isAutoClosable() {
        return true;
    }

    default String toHTML() {
        StringWriter sw = new StringWriter();
        write(sw, "", EOL);
        return sw.toString();
    }

    default T writeOpener(StringWriter sw, String prefix, boolean close, String eol) {
        sw.write(prefix + "<" + name());

        getAttributes().forEach((k, v) -> sw.write(" " + k + "=" + ATTR_QUOTE + escapeAttributeValue(v) + ATTR_QUOTE));
        sw.write(close ? "/>" : ">");
        sw.write(eol);
        return self();
    }

    default String escapeAttributeValue(Object v) {
        return Escaping.escapeAttributeValue(v);
    }

    default T writeChildren(StringWriter sw, String prefix) {
        getChildren().forEach(c -> c.write(sw, prefix, EOL));
        return self();
    }

    default T writeEnd(StringWriter sw, String prefix) {
        sw.write(prefix + "</" + name() + ">" + EOL);
        return self();
    }

    default T write(StringWriter sw, String prefix, String eol) {
        if (getChildren().isEmpty() && isAutoClosable()) {
            return writeOpener(sw, prefix, true, EOL);
        } else if( fitsOnSingleLine()) {
            writeOpener(sw, prefix, false, "");
            getChildren().get(0).write(sw, "", "");
            writeEnd(sw,"");
            return self();
        } else {
            writeOpener(sw, prefix, false, EOL);
            writeChildren(sw, prefix + "  ");
            writeEnd(sw, prefix);
            return self();
        }
    }

    default boolean fitsOnSingleLine() {
        boolean singleString = getChildren().size()==1 && self().getChildren().get(0) instanceof Str;
        int max = COL_BREAK_LIMIT - 2 * name().length();
        return singleString && getChildren().get(0).toHTML().length() < max;
    }

}
