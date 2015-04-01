package no.dv8.xhtml.generation.support;

import no.dv8.xhtml.generation.elements.*;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        List<String> images = asList("image1.png", "image2.png");

        html x = new html()
                // Lots of predefined attributes, somewhat according to the standard:
                .id("the id")
                .clz("theclass")
                        // Unsupported (forgottten...) attributes can be specified explicitly:
                .set("basedir", "http:abasdf")
                .set("style", "display:inline")
                .add(
                        new head()
                        .add( new link()
                                .rel( "reltype")
                                .href( "http:/...")
                        )
                ).add(
                        new body().add(
                                new p()
                                        // Text can be added directly. Note that
                                        // end-of-lines is probably not handled the
                                        // way you want/expect, due to pretty-formatting
                                        // the output.
                                        .add("asdf")
                                        .add("qwer")
                                        .add("zxcv\n1234")
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


        System.out.println(x);

        // Generates something like this
/*
<html basedir='http:abasdf' style='display:inline' id='the id' class='theclass'>
    <body>
        <p>
            asdf
            qwer
            zxcv
            1234
            <a rel='reltype' href='the href'>
                please click me
            </a>
            <img src='image1.png'/>
            <img src='image2.png'/>
            <form method='PUT' action='the-web-api'>
                <input type='thetype' value='the value'>
                    shouldnt be text inside inputs...
                </input>
            </form>
            <ionic-section data-myapp='something'/>
        </p>
    </body>
</html>
*/
    }
}
