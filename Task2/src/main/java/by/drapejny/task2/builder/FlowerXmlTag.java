package by.drapejny.task2.builder;

public enum FlowerXmlTag {
    FLOWERS("flowers"),
    ANNUAL_FLOWER("annual-flower"),
    PERENNUAL_FLOWER("perennual-flower"),
    NAME("name"),
    ORIGIN("origin"),
    VISUAL_ASPECT("visual-aspect"),
    SIZE("size"),
    LEAVES_COLOR("leaves-color"),
    BLOSSOM_COLOR("blossom-color"),
    SOIL("soil"),
    GROWING_TEMPERATURE("growing-temperature"),
    IS_LIGHT_LOVING("is-light-loving"),
    WATERING("watering"),
    MULTIPLYING("multiplying"),
    FLOWERING_PERIOD("flowering-period"),
    IS_WINTERING("is-wintering");
    private String value;

    FlowerXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
