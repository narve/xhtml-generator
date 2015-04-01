package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface For<T extends For> extends Attributable<T> {
    default T clz(String clz) {
        return set("for", clz);
    }
}
