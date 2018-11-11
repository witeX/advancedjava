package scammer.context;

import scammer.ClassificationContext;

public class ChatMessage implements ClassificationContext<String> {
    private Long sender;
    private Long receiver;
    private String text;

    public ChatMessage(Long sender, Long receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }

    @Override
    public Long getUserId() {
        return sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    @Override
    public String getPayload() {
        return text;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", text='" + text + '\'' +
                '}';
    }
}
