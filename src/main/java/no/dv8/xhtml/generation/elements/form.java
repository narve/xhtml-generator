package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.support.ElementBase;

public class form extends ElementBase<form> {

    public form action(String a) {
        set( "action", a );
        return self();
    }

    public form method(String m) {
        set( "method", m );
        return self();
    }

}
