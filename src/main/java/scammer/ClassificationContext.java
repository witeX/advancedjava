package scammer;

public interface ClassificationContext<T> {

    Long getUserId();

    T getPayload();
}
