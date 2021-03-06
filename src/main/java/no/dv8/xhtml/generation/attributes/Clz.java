package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Clz<T extends Clz> extends Attributable<T> {

    default T clz(Object clz) {
        return set("class", clz);
    }

    default T addClz(Object clz) {
        if( get("class")==null) {
            return clz(clz);
        } else {
            return clz(get("class") + " " + clz);
        }
    }
}
