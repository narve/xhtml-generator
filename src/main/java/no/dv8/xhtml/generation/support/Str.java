package no.dv8.xhtml.generation.support;

import java.io.StringWriter;

import static java.util.Arrays.asList;

public class Str extends ElementBase<Str> {
    String text;

    public Str(String s) {
        this.text = s;
    }

    @Override
    public Str write(StringWriter sw, String prefix, String eol) {
        if( text == null ) {
            return self();
        }
        asList( text.split( "\n" ) )
                .stream()
                .forEach(s -> sw.write( prefix + escapeText(s) + eol ));
        return self();
    }

    public String escapeText(String s) {
        return Escaping.escapeText(s);
    }
}