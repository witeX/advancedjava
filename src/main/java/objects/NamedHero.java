package objects;

public class NamedHero<K> extends KeyValue<K, Hero> {
    public NamedHero(K key, Hero value) {
        super(key, value);
    }
}
