package scammer.context;

import scammer.ClassificationContext;

public class UserNameContext implements ClassificationContext<String> {
    private Long userId;
    private String userName;

    public UserNameContext(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public String getPayload() {
        return userName;
    }
}
