import scammer.ClassificationContext;
import scammer.ClassificationResult;
import scammer.Classifier;
import scammer.classifiers.ChatMessageClassifier;
import scammer.classifiers.IpAddressClassification;
import scammer.classifiers.UserNameClassifier;
import scammer.context.ChatMessage;
import scammer.context.IpAddressContext;
import scammer.context.UserNameContext;
import scammer.results.IpClassificationResult;
import scammer.results.TextClassificationResult;
import scammer.rule.IpRule;
import scammer.rule.TextRule;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ScammerClassification {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Execute classifyUserName");
        classifyUserName();
        System.out.println("Execute classifyChatMessages");
        classifyChatMessages();
        System.out.println("Execute classifyIP");
        classifyIP();
    }


    private static void classifyUserName() {
        List<UserNameClassifier> userNameClassifiers = getUserNameClassifiers();

        classifyUserName(userNameClassifiers, 1L, "good name");
        classifyUserName(userNameClassifiers, 1L, "scammer");
    }

    private static List<UserNameClassifier> getUserNameClassifiers() {
        List<UserNameClassifier> userNameClassifiers = new ArrayList<>();
        Classifier<UserNameContext, TextClassificationResult> cls = new UserNameClassifier(new TextRule("u:1", "bad user name"));
        userNameClassifiers.add(new UserNameClassifier(new TextRule("u:1", "bad user name")));
        userNameClassifiers.add(new UserNameClassifier(new TextRule("u:2", "Alex")));
        userNameClassifiers.add(new UserNameClassifier(new TextRule("u:3", "scammer")));
        return userNameClassifiers;
    }

    private static void classifyUserName(List<UserNameClassifier> userNameClassifiers, long userId, String userName) {
        List<TextClassificationResult> clearClassification = classify(userNameClassifiers, new UserNameContext(userId, userName));
        proceedClassificationResult(clearClassification);
        processTextClassificationResult(clearClassification);
    }

    private static <C extends ClassificationContext, R extends ClassificationResult> List<R> classify(List<? extends Classifier<C, R>> chatClassifiers, final C chatMessage) {
        List<R> list = new ArrayList<>();
        for (Classifier<? super C, ? extends R> chatMessageClassifier : chatClassifiers) {
            R classify = chatMessageClassifier.classify(chatMessage);
            if (classify.isMatchClassification()) {
                list.add(classify);
            }
        }
        return list;
    }

    private static void proceedClassificationResult(List<? extends ClassificationResult> results) {
        System.out.println("Processing classification results for list size:" + results.size());
        for (ClassificationResult result : results) {
            System.out.printf("Mark user as scammer with rule: %s", result.ruleName());
            System.out.println();
        }
    }

    private static void processTextClassificationResult(List<TextClassificationResult> results) {
        System.out.println("Processing chat classification results for list size:" + results.size());
        for (TextClassificationResult result : results) {
            System.out.printf("User marked as scammer with rule: %s for text '%s'", result.ruleName(), result.getMatchedText());
            System.out.println();
        }
    }

    private static void classifyChatMessages() {
        List<ChatMessageClassifier> chatClassifiers = getChatClassifiers();
        ChatMessage chatMessage = new ChatMessage(1L, 2L, "normalText");
        ChatMessage chatMessage2 = new ChatMessage(1L, 2L, "here is fuck in text");

        classifyChatMessage(chatClassifiers, chatMessage);
        classifyChatMessage(chatClassifiers, chatMessage2);
    }

    private static List<ChatMessageClassifier> getChatClassifiers() {
        List<ChatMessageClassifier> messageClassifiers = new ArrayList<>();
        messageClassifiers.add(new ChatMessageClassifier(new TextRule("t:1", "scammer")));
        messageClassifiers.add(new ChatMessageClassifier(new TextRule("t:2", "fuck")));
        messageClassifiers.add(new ChatMessageClassifier(new TextRule("t:3", "give me money")));
        return messageClassifiers;
    }

    private static void classifyChatMessage(List<ChatMessageClassifier> chatClassifiers, ChatMessage chatMessage) {
        List<TextClassificationResult> clearClassification = classify(chatClassifiers, chatMessage);
        proceedClassificationResult(clearClassification);
        processTextClassificationResult(clearClassification);
    }

    private static void classifyIP() throws UnknownHostException {
        List<IpAddressClassification> userIpClassifiers = getUserIpClassifiers();

        classifyIp(userIpClassifiers, "127.0.0.2");
        classifyIp(userIpClassifiers, "127.0.3.2");
    }

    private static List<IpAddressClassification> getUserIpClassifiers() throws UnknownHostException {
        List<IpAddressClassification> ipAddressClassifications = new ArrayList<>();
        ipAddressClassifications.add(new IpAddressClassification(new IpRule("ip:1", Inet4Address.getByName("127.0.0.1"))));
        ipAddressClassifications.add(new IpAddressClassification(new IpRule("ip:2", Inet4Address.getByName("127.0.0.2"))));
        ipAddressClassifications.add(new IpAddressClassification(new IpRule("ip:3", Inet4Address.getByName("127.2.0.2"))));
        return ipAddressClassifications;
    }

    private static void classifyIp(List<IpAddressClassification> userIpClassifiers, String s) throws UnknownHostException {
        List<IpClassificationResult> results = classify(userIpClassifiers, new IpAddressContext(1L, Inet4Address.getByName(s)));
        proceedClassificationResult(results);
        processIpClassificationResult(results);
    }

    private static void processIpClassificationResult(List<IpClassificationResult> results) {
        System.out.println("Processing chat classification results for list size:" + results.size());
        for (IpClassificationResult result : results) {
            System.out.printf("User marked as scammer with rule: %s for ip'%s'", result.ruleName(), result.getIpAddress());
            System.out.println();
        }
    }
}
