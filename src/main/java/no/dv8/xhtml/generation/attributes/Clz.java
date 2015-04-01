package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Clz<T extends Clz> extends Attributable<T> {

    default T clz(String clz) {
        return set("class", clz);
    }
}
