package scammer.rule;

import scammer.Rule;

import java.util.Date;

public class TextRule implements Rule {
    private String name;
    private String badText;

    public TextRule(String name, String badText) {
        this.name = name;
        this.badText = badText;
    }

    @Override
    public String getRuleName() {
        return name;
    }

    public String getBadText() {
        return badText;
    }
}
