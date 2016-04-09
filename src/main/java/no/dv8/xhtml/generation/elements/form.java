package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.support.ElementBase;

public class form extends ElementBase<form> {

    public static enum Method {
        get, post
    }

    public form action(Object a) {
        set( "action", a );
        return self();
    }

    public form method(Object m) {
        set( "method", m );
        return self();
    }

    public form get() {
        return method( Method.get );
    }

    public form post() {
        return method( Method.post );
    }

}
