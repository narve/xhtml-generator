package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Id<T extends Id> extends Attributable<T> {
    default T id(Object h) {
        return set("id", h);
    }

}
