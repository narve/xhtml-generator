package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Property<T extends Property> extends Attributable<T> {

    default T property(String t) {
        return set("property", t);
    }

}
