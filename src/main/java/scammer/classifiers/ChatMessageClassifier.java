package scammer.classifiers;

import scammer.Classifier;
import scammer.context.ChatMessage;
import scammer.results.TextClassificationResult;
import scammer.rule.TextRule;

public class ChatMessageClassifier implements Classifier<ChatMessage, TextClassificationResult> {
    private final TextRule rule;

    public ChatMessageClassifier(TextRule rule) {
        this.rule = rule;
    }

    @Override
    public TextClassificationResult classify(ChatMessage context) {

        boolean contains = context.getPayload().contains(rule.getBadText());

        return new TextClassificationResult(rule.getRuleName(), contains, contains ? rule.getBadText() : "");
    }

}
