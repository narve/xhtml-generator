package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Rel<T extends Rel> extends Attributable<T> {

    default T rel(Object h) {
        set("rel", h);
        return self();
    }

}
