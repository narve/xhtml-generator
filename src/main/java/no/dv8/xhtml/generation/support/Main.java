package no.dv8.xhtml.generation.support;

import no.dv8.xhtml.generation.elements.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Main {
  public static void main(String[] args) throws IOException {

    List<String> images = asList("image1.png", "image2.png");

    html x = new html()
        // Various predefined attributes, somewhat according to the standard:
        .id("the id")
        .clz("theclass")
            // Unsupported (forgottten...) attributes can be specified explicitly:
        .set("basedir", "http:abasdf")
            // Escaping is done automatically (but probably not 100% correct):
        .set("style", "before: \"<>&'")
        .add(
            new head()
                .add(new link()
                        .rel("reltype")
                        .href("http:/...")
                )
        ).add(
            new body()
                // Some constructors take the text content directly, whenever it seems appropriate:
                .add(new h1("Headers!!"))
                .add(new p("one paragraph").add(new span("with some text in a span")))
                .add(
                    new p()
                        // Text can be added directly. Note that
                        // end-of-lines is probably not handled the
                        // way you want/expect, due to pretty-formatting
                        // the output.
                        .add("asdf")
                        .add("qwer")
                        .add("zxcv\n1234")
                            // Text is escaped automatically (but probably not 100% correct):
                        .add("lots of html: < > & ; \" <input />")
                        .add(
                            new a()
                                .href("the href")
                                .rel("reltype")
                                .add("please click me")

                        ).add(
                        // You can add collection of elements,
                        // works great with lambdas
                        images
                            .stream()
                            .map(i -> new img().src(i))
                            .collect(toList())
                    )
                        .add(
                            new form()
                                .action("the-web-api")
                                .method("PUT")  // No html conformance checking!
                                .add(
                                    new input()
                                        .type("thetype")
                                        .value("the value")
                                            // No html conformance checking:
                                        .add("shouldnt be text inside inputs...")
                                )
                        ).add(
                        // Custom elements are supported for whatever I miss/forget
                        new Custom("ionic-section")
                            .set("data-myapp", "something")
                    )
                )
        );


    Path p = new File("output.html").toPath();
    Files.write(p, x.toString().getBytes());
    System.out.println("Output written to " + p.toAbsolutePath());
  }
}
