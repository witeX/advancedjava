package scammer.classifiers;

import scammer.Classifier;
import scammer.context.UserNameContext;
import scammer.results.TextClassificationResult;
import scammer.rule.TextRule;

public class UserNameClassifier implements Classifier<UserNameContext, TextClassificationResult> {

    private final TextRule rule;

    public UserNameClassifier(TextRule rule) {
        this.rule = rule;
    }

    @Override
    public TextClassificationResult classify(UserNameContext context) {
        boolean equals = context.getPayload().equals(rule.getBadText());
        return new TextClassificationResult(rule.getRuleName(), equals, equals ? rule.getBadText() : "");
    }
}
