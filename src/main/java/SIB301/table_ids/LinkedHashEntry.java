package SIB301.table_ids;

/**
 * Created by dmitriy on 05.12.2016.
 */
public class LinkedHashEntry <T> {
    private String name;
    private T value;
    LinkedHashEntry next;

    public LinkedHashEntry(String name, T value) {
        this.name = name;
        this.value = value;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedHashEntry getNext() {
        return next;
    }

    public void setNext(LinkedHashEntry next) {
        this.next = next;
    }

    @Override
    public int hashCode() {
        int hash = name.hashCode();
        return hash < 0 ? -hash : hash;
    }
}
