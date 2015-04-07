package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface ReadOnly<T extends Required> extends Attributable<T> {
    default T readonly(String h) {
        return set("readonly", h);
    }

    default T readonly() {
        return readonly("readonly");
    }

    default T readonly(boolean ro) {
        return ro ? readonly() : readonly(null);
    }

}
