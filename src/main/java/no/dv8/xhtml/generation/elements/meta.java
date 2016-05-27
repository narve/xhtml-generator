package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.support.ElementBase;

public class meta extends ElementBase<meta> {
    public meta charset(Object a) {
        set( "charset", a );
        return self();
    }

}
