package no.dv8.xhtml.generation.attributes;

import no.dv8.xhtml.generation.support.Attributable;

public interface Itemprop<T extends Itemprop> extends Attributable<T>{
    default T itemprop( String itemprop ) {
        return set( "itemprop", itemprop );
    }
}
