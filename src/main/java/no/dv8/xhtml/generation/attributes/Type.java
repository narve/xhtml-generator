package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Type<T extends Type> extends Attributable<T> {
    default T type(Object clz) {
        return set("type", clz);
    }
}
