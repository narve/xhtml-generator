package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Required<T extends Required> extends Attributable<T> {
    default T required(String h) {
        return set("required", h);
    }

    default T required() {
        return required("required");
    }

    default T required(boolean req) {
        return req ? required() : required(null);
    }
}
