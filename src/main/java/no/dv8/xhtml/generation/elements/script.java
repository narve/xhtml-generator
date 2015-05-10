package no.dv8.xhtml.generation.elements;

import no.dv8.xhtml.generation.attributes.Src;
import no.dv8.xhtml.generation.attributes.Type;
import no.dv8.xhtml.generation.support.ElementBase;

public class script extends ElementBase<script> implements Src<script>, Type<script> {
    @Override
    public boolean isAutoClosable() {
        return false;
    }
}
