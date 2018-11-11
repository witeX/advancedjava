package scammer.rule;

import scammer.Rule;

import java.net.Inet4Address;
import java.net.InetAddress;

public class IpRule implements Rule {

    private final InetAddress address;
    private final String ruleName;

    public IpRule(String ruleName, InetAddress address) {
        this.address = address;
        this.ruleName = ruleName;
    }

    public InetAddress getAddress() {
        return address;
    }

    @Override
    public String getRuleName() {
        return ruleName;
    }
}
