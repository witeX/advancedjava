package objects;

public class NamedActiveEnemy<K, T extends Enemy & Active> extends KeyValue<K,T> {

    public NamedActiveEnemy(K key, T value) {
        super(key, value);
    }
}
