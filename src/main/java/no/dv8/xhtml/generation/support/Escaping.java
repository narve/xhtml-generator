package no.dv8.xhtml.generation.support;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Could be replaced with a proper one, e.g. StringEscapeUtils. But I hate dependencies...
 */
public class Escaping {

    private static final Map<Character, String> attrEscapes = Collections.unmodifiableMap(attrEscapes());
    private static final Map<Character, String> textEscapes = Collections.unmodifiableMap(textEscapes());

    public static String escapeAttributeValue(Object in) {
        return escape(in, attrEscapes);
    }

    public static String escapeText(String in) {
        return escape(in, textEscapes);
    }

    public static String escape(Object in, Map<Character, String> escapes) {
        if( in == null ) return null;
        StringBuilder sb = new StringBuilder();
        boolean changed = false;
        char[] ca = in.toString().toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (escapes.containsKey(ca[i])) {
                sb.append(escapes.get(ca[i]));
                changed = true;
            } else {
                sb.append(ca[i]);
            }
        }
        return changed ? sb.toString() : in.toString();
    }

    static Map<Character, String> attrEscapes() {
        HashMap<Character, String> m = new HashMap<>();
//        m.put( '"', "&quot;"); Not necessary when we use ' as attribute value delimiters
        m.put('\'', "&apos;");
        m.put('&', "&amp;");
        return m;
    }

    static Map<Character, String> textEscapes() {
        HashMap<Character, String> m = new HashMap<>();
        m.put('&', "&amp;");
        m.put('<', "&lt;");
        return m;
    }

}
