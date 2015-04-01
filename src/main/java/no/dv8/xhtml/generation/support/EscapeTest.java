package no.dv8.xhtml.generation.support;

import no.dv8.xhtml.generation.elements.div;

public class EscapeTest {

    public static void main(String[] args) {
        div d = new div()
        .set("a1","\"")
                .set( "a2", "'")
                .set( "a3", "!#$%/()=")
                .set( "a4", "&" )
                .set( "a5", "<>" );
        System.out.println(d.toString());
    }

}
