package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Itemscope<T extends Itemscope> extends Attributable<T> {
    default T itemscope(String h) {
        return set("itemscope", h);
    }

    default T itemscope() {
        return itemscope("itemscope");
    }

}
