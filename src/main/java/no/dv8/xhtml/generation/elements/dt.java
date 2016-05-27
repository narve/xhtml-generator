package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.support.ElementBase;

import static java.lang.String.valueOf;

public class dt extends ElementBase<dt> {
    public dt() {
        super();
    }

    public dt(Object content) {
        super();
        add(valueOf(content));
    }
}
