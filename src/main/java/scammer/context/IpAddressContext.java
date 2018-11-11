package scammer.context;

import scammer.ClassificationContext;

import java.net.InetAddress;

public class IpAddressContext implements ClassificationContext<InetAddress> {
    private Long userId;
    private InetAddress address;

    public IpAddressContext(Long userId, InetAddress address) {
        this.userId = userId;
        this.address = address;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public InetAddress getPayload() {
        return address;
    }
}
