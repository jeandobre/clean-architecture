package br.exemplo.enums;

import java.util.Set;

public class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // Qualquer set pode ser passado, mas a EnumSet é evidentemente melhor
    public void applyStyles(Set<Style> styles){

    }
}
