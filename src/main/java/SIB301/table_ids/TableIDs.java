package SIB301.table_ids;

/**
 * Created by dmitriy on 05.12.2016.
 */

public class TableIDs <T>{
    private final int TABLE_SIZE ;

    private LinkedHashEntry<T>[] table;

    public TableIDs() {
        this(10);
    }

    public TableIDs(int tableSize) {
        this.TABLE_SIZE = tableSize;
        this.table = new LinkedHashEntry[TABLE_SIZE];
    }


    public void put(String name, T value) {
        int hash = name.hashCode();
        hash = hash < 0 ? -hash : hash;
        hash = (hash % TABLE_SIZE);
        if (table[hash] == null)
            table[hash] = new LinkedHashEntry(name, value);
        else {
            LinkedHashEntry<T> entry = table[hash];
            while (entry.getNext() != null && !entry.getName().equals(name))
                entry = entry.getNext();
            if (entry.getName().equals(name))
                entry.setValue(value);
            else
                entry.setNext(new LinkedHashEntry(name, value));
        }

    }

    public T get(String name) {
        int hash = name.hashCode();
        hash = hash < 0 ? -hash : hash;
        hash = (hash % TABLE_SIZE);
        if (table[hash] == null)
            return null;
        else {
            LinkedHashEntry<T> entry = table[hash];
            while (entry != null && !entry.getName().equals(name))
                entry = entry.getNext();
            if (entry == null)
                return null;
            else
                return entry.getValue();
        }
    }

    public void remove(String name) {
        int hash = name.hashCode();
        hash = hash < 0 ? -hash : hash;
        hash = (hash % TABLE_SIZE);
        if (table[hash] != null) {
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && !entry.getName().equals(name)) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getName().equals(name)) {
                if (prevEntry == null)
                    table[hash] = entry.getNext();
                else
                    prevEntry.setNext(entry.getNext());
            }
        }
    }
}
