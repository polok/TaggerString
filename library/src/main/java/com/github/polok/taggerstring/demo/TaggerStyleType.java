package com.github.polok.taggerstring.demo;

public enum TaggerStyleType {

    BOLD("<b>", "</b>"),
    UNDERLINE("<u>", "</u>"),
    ITALIC("<i>", "</i>");

    private String tagStart;
    private String tagEnd;

    private TaggerStyleType(String tagStart, String tagEnd) {
        this.tagStart = tagStart;
        this.tagEnd = tagEnd;
    }

    public String getTagStart() {
        return tagStart;
    }

    public String getTagEnd() {
        return tagEnd;
    }
}
