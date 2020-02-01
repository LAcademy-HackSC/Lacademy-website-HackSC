import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class City implements Map<String, Object> {
    public String city;
    public String state;
    public String country;
    public boolean b;
    public long l;

    public City(String city, String state, String country, boolean b, long l) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.b = b;
        this.l = l;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(String key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Object> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return null;
    }
}
