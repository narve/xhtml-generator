package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.attributes.For;
import no.dv8.xhtml.generation.support.ElementBase;

public class label extends ElementBase<label> implements For<label> {
    public label() {
        super();
    }
    public label( String content ) {
        super();
        add( content );
    }

}
