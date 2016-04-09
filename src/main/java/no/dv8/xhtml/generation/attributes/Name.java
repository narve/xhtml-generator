package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Name<T extends Name> extends Attributable<T> {
    default T name(Object h) {
        return set("name", h);
    }

}
