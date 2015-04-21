package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Typeof<T extends Typeof> extends Attributable<T> {

    default T typeof(String t) {
        return set("typeof", t);
    }

}
