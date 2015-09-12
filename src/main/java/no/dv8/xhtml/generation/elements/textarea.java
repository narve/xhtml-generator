package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.attributes.*;
import no.dv8.xhtml.generation.support.ElementBase;

import java.io.StringWriter;

/** This class does not prettify with blanks / prefixes! */
public class textarea extends ElementBase<textarea> implements Name<textarea>, Required<textarea>, ReadOnly<textarea> {
    public textarea() {
        super();
    }
    public textarea( String content ) {
        super();
        add(content);
    }
    /** Override this - skip prefix within textareas */
    public textarea write(StringWriter sw, String prefix, String eol) {
        writeOpener(sw, prefix, false, "");
        writeChildren(sw, "");
        writeEnd(sw, "");
        return self();
    }

    public textarea writeChildren(StringWriter sw, String prefix) {
        getChildren().forEach(c -> c.write(sw, "", EOL));
        return self();
    }


}
