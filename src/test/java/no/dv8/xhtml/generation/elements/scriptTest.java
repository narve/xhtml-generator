package no.dv8.xhtml.generation.elements;

import org.junit.Test;

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

}