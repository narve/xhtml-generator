package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.support.ElementBase;

public class legend extends ElementBase<legend> {
    public legend( Object content ) {
        super();
        add( content == null ? null : content.toString());
    }
}
