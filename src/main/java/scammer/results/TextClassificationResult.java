package scammer.results;

import scammer.ClassificationResult;

public class TextClassificationResult implements ClassificationResult {
    private String ruleName;
    private boolean matched;
    private String matchedText;

    public TextClassificationResult(String ruleName, boolean matched, String matchedText) {
        this.ruleName = ruleName;
        this.matched = matched;
        this.matchedText = matchedText;
    }

    @Override
    public boolean isMatchClassification() {
        return matched;
    }

    @Override
    public String ruleName() {
        return ruleName;
    }


    public String getMatchedText() {
        return matchedText;
    }
}
