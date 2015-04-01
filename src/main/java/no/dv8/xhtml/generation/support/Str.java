package no.dv8.xhtml.generation.support;

import java.io.StringWriter;

import static java.util.Arrays.asList;

public class Str extends ElementBase<Str> {
    String text;

    public Str(String s) {
        this.text = s;
    }

    public Str write(StringWriter sw, String prefix) {
        //TODO: XML-escape the text
        asList( text.split( "\n" ) )
                .stream()
                .forEach(s -> sw.write( prefix + s + EOL ));
//        sw.write(text + EOL);
        return self();
    }
}
