package scammer.classifiers;

import scammer.Classifier;
import scammer.context.IpAddressContext;
import scammer.results.IpClassificationResult;
import scammer.rule.IpRule;

public class IpAddressClassification implements Classifier<IpAddressContext, IpClassificationResult> {
    private final IpRule ipRule;

    public IpAddressClassification(IpRule ipRule) {
        this.ipRule = ipRule;
    }

    @Override
    public IpClassificationResult classify(IpAddressContext context) {
        boolean equals = context.getPayload().equals(ipRule.getAddress());

        return new IpClassificationResult(ipRule.getRuleName(), equals, equals ? context.getPayload() : null);
    }
}
