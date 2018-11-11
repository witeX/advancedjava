package objects;

public class NamedEnemy<K> extends KeyValue<K, Enemy> {
    public NamedEnemy(K key, Enemy value) {
        super(key, value);
    }
}
