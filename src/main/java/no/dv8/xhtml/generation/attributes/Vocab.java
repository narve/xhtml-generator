package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Vocab<T extends Vocab> extends Attributable<T> {

    default T vocab(String t) {
        return set("vocab", t);
    }

}
