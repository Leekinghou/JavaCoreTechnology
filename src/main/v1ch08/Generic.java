package v1ch08;

/**
 * @author: lijinhao
 * @date: 2021/11/24 17:35
 */
public class Generic<T> {
    private T key;

    /**
     *
     * @param key
     */
    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "key=" + key +
                '}';
    }
}
