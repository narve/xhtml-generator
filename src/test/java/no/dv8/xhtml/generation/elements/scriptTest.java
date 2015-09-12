package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.support.Element;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class scriptTest {

    @Test
    public void testThatScriptDontAutoclose() {
        script s = new script().src( "asdf");
        String s1 = s.toHTML();
        assertThat( s1, containsString("</script>"));
        System.out.println(s1);
    }

    @Test
    public void testAOnSingleLine() {
        a a = new a( "text").href("href");
        String s = a.toHTML();
        assertThat(s, equalTo("<a href='href'>text</a>" + Element.EOL));
    }

    @Test
    public void testAOnMultipleLines() {
        String text = "";
        while( text.length() < Element.COL_BREAK_LIMIT ) text+="thetext";
        a a = new a( text).href( "href");
        String s = a.toHTML();
        assertThat( s, not( equalTo( "<a href='href'>" + text + "</a>" + Element.EOL)));
        assertThat( s, containsString(Element.EOL));
        System.out.println(s);
    }

}