package no.dv8.xhtml.generation.support;

import java.util.List;
import java.util.Map;

public interface Attributable<T extends Attributable> {


    default T self() {
        return (T) this;
    }

    List<Element<?>> getChildren();

    Map<String, String> getAttributes();

    default T set(String k, String v) {
        // TODO: check attribute keys perhaps?
        getAttributes().put(k, v);
        return self();
    }


}