package scammer;

public interface Classifier<C extends ClassificationContext
        , R extends ClassificationResult> {

    R classify(C context);

}
