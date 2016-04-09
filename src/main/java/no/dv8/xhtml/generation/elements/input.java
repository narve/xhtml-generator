package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.attributes.*;
import no.dv8.xhtml.generation.support.ElementBase;

public class input extends ElementBase<input> implements Type<input>, Value<input>, Placeholder<input>, Required<input>, ReadOnly<input>, Name<input> {

    public static enum Type {
        text, submit, password, file
    }

    public input text() {
        return type( Type.text);
    }
    public input submit() {
        return type( Type.submit);
    }
    public input password() {
        return type( Type.password);
    }
    public input file() {
        return type( Type.file);
    }
}
