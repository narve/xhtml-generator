package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Src<T extends Src> extends Attributable<T> {

    default T src(String src) {
        set("src", src);
        return self();
    }

}

