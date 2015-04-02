package no.dv8.xhtml.generation.support;

import java.io.StringWriter;

import static java.util.Arrays.asList;

public class Str extends ElementBase<Str> {
    String text;

    public Str(String s) {
        this.text = s;
    }

    public Str write(StringWriter sw, String prefix) {
        if( text == null ) return self();
        asList( text.split( "\n" ) )
                .stream()
                .forEach(s -> sw.write( prefix + escapeText(s) + EOL ));
        return self();
    }

    public String escapeText(String s) {
        return Escaping.escapeText(s);
    }
}