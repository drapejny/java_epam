package by.drapejny.task5.entity;

public enum TextComponentType {
    TEXT,
    PARAGRAPH("\t","\r\n"),
    SENTENCE(""," "),
    LEXEME(" ",""),
    WORD,
    PUNCTUATION,
    SYMBOL;

    private String prefix = "";
    private String suffix = "";

    TextComponentType() {}

    TextComponentType(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
