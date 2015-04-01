package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Placeholder<T extends Placeholder> extends Attributable<T> {
    default T placeholder(String h) {
        return set("placeholder", h);
    }
}
