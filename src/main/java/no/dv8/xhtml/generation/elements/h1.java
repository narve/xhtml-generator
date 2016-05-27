package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.support.ElementBase;

public class h1 extends ElementBase<h1> {
    public h1() {
        super();
    }
    public h1( Object content ) {
        super();
        add( String.valueOf(content ));
    }
}
