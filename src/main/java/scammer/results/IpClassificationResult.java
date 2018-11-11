package scammer.results;

import scammer.ClassificationResult;

import java.net.Inet4Address;
import java.net.InetAddress;

public class IpClassificationResult implements ClassificationResult {
    private String ruleName;
    private boolean match;
    private InetAddress ipAddress;

    public IpClassificationResult(String ruleName, boolean match, InetAddress ipAddress) {
        this.ruleName = ruleName;
        this.match = match;
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean isMatchClassification() {
        return match;
    }

    @Override
    public String ruleName() {
        return ruleName;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }
}
