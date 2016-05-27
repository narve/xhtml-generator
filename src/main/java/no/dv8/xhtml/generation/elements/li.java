package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.support.ElementBase;

public class li extends ElementBase<li> {
    public li() {
        super();
    }
    public li( Object content ) {
        super();
        add( String.valueOf( content ));
    }
}
