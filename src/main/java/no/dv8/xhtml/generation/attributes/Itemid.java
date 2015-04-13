package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Itemid<T extends Itemid> extends Attributable<T> {
    default T Itemid(String itemid) {
        return set("itemid", itemid);
    }
}
