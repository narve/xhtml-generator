package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.attributes.Placeholder;
import no.dv8.xhtml.generation.attributes.Type;
import no.dv8.xhtml.generation.attributes.Value;
import no.dv8.xhtml.generation.support.ElementBase;

import java.io.StringWriter;

public class textarea extends ElementBase<textarea> implements Type<textarea>, Value<textarea>, Placeholder<textarea> {
    public textarea() {
        super();
    }
    public textarea( String content ) {
        super();
        add(content);
    }
    /** Override this - not all browsers handle self-closing textarea tags. */
    public textarea write(StringWriter sw, String prefix) {
        writeOpener(sw, prefix, false);
        writeChildren(sw, prefix + "  ");
//        sw.write( "textarea content?");
        writeEnd(sw, prefix);
        return self();
    }

}
