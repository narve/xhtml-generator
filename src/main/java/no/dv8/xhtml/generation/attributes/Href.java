package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Href<T extends Href> extends Attributable<T> {

    default T href(Object h) {
        return set("href", h);
    }

    default Object href() {
        return get("href");
    }

}
