package com.xu.core.util.types;

import java.io.Serializable;
import java.util.Set;

public class Text implements Serializable {

    public static final String TYPE_PLAIN = "text/plain";

    public static final String TYPE_HTML = "text/html";

    public static final Set<String> KNOWN_TYPES = Set.of(TYPE_PLAIN, TYPE_HTML);

    private final String content;

    private final String type;

    public static Text plain(String content) {
        return new Text(TYPE_PLAIN, content);
    }


    public static Text html(String content) {
        return new Text(TYPE_HTML, content);
    }
    public Text(String type, String content) {
        this.type = type;
        this.content = content;
    }


    public boolean isPlain() {
        return TYPE_PLAIN.equals(this.type);
    }

    public boolean isHtml() {
        return TYPE_HTML.equals(this.type);
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }
}
