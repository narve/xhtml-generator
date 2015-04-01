package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Value<T extends Value> extends Attributable<T> {
    default T value(String clz) {
        return set("value", clz);
    }
}
