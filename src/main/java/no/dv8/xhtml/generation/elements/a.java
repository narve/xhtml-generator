package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.attributes.Href;
import no.dv8.xhtml.generation.attributes.Rel;
import no.dv8.xhtml.generation.support.ElementBase;

public class a extends ElementBase<a> implements Rel<a>, Href<a> {
    public a() {
        super();
    }

    public a(String content) {
        super();
        add(content);
    }
}
