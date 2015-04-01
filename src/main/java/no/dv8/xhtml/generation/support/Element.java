package no.dv8.xhtml.generation.support;

import no.dv8.xhtml.generation.attributes.Clz;
import no.dv8.xhtml.generation.attributes.Id;
import no.dv8.xhtml.generation.attributes.Type;

import java.io.StringWriter;
import java.util.*;

public interface Element<T extends Element> extends Id<T>, Clz<T> {

    String name();

    default T self() {
        return (T) this;
    }

    List<Element<?>> getChildren();

    default T add(Element a) {
        getChildren().add(a);
        return self();
    }

    default T add(Collection<Element<?>> a) {
        getChildren().addAll(a);
        return self();
    }

    default T add(String s) {
        return add(new Str(s));
    }


    default String toHTML() {
        StringWriter sw = new StringWriter();
        write(sw, "");
        return sw.toString();
    }


    static final String EOL = "\r\n";

    default T writeOpener(StringWriter sw, String prefix, boolean close) {
        sw.write(prefix + "<" + name());

        //TODO: Escape attribute values (and check attribute keys perhaps?)
        getAttributes().forEach((k, v) -> sw.write(" " + k + "='" + v + "'"));
        sw.write(close ? "/>" : ">");
        sw.write(EOL);
        return self();
    }

    default T writeChildren(StringWriter sw, String prefix) {
        getChildren().forEach(c -> c.write(sw, prefix + "  "));
        return self();
    }

    default T writeEnd(StringWriter sw, String prefix) {
        sw.write(prefix + "</" + name() + ">" + EOL);
        return self();
    }

    default T write(StringWriter sw, String prefix) {
        if (getChildren().isEmpty()) {
            return writeOpener(sw, prefix, true);
        } else {
            writeOpener(sw, prefix, false);
            writeChildren(sw, prefix + "  ");
            writeEnd(sw, prefix);
            return self();
        }
    }

}
