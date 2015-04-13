package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Itemtype<T extends Itemtype> extends Attributable<T> {
    default T itemtype(String itemtype) {
        return set("itemtype", itemtype);
    }
}
