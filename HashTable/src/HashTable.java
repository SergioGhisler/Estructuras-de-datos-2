import java.util.LinkedList;

public class HashTable {

    class KeyValue {
        String key;
        int value;

        KeyValue(String k, int v) {
            key = k;
            value = v;
        }
    }

    private double loadFactor;
    private int populated, capacity;
    private LinkedList<KeyValue>[] table;

    @SuppressWarnings({"unchecked"})  // ugly workaround
    private LinkedList<KeyValue>[] initHashTable(int c) {
        LinkedList<KeyValue>[] table = new LinkedList[c];
        for (int i = 0; i < c; ++i) {
            table[i] = new LinkedList<>();
        }
        return table;
    }

    public HashTable(int c) {
        table = initHashTable(c);
        loadFactor = 0.0;
        capacity = c;
        populated = 0;
    }

    // Capacity is 10 if none is specified
    public HashTable() {
        this(10);
    }

    private int getHash(String key) {
        // Convert each char in number
        // Return absolute value of remainder with current capacity
        int total = 0;
        for (int i = 0; i < key.length(); i++) {
            total += (int) key.charAt(i);
        }

        return (total % capacity);
    }

    private void updateLoadFactor() {
        loadFactor = (double) populated/capacity;
    }

    private void reHash() throws Exception {
        capacity *= 2;
        HashTable temp = new HashTable(capacity);

        for (LinkedList<KeyValue> l : table) {
            for (KeyValue kv : l) {
                temp.set(kv.key, kv.value);
            }
        }

        this.table = temp.table;
        this.capacity = temp.capacity;
        this.loadFactor = temp.loadFactor;
        this.populated = temp.populated;
    }

    public void set(String key, int value) throws Exception {
        // Hash the key
        // If the list is empty update populated
        // Add KeyValue to list
        // Update loadFactor
        // If loadFactor > 0.7 reHash
        int hashedKey = getHash(key);
        if (table[hashedKey].isEmpty()) {
            populated++;
        }

        table[hashedKey].add(new KeyValue(key, value));

        updateLoadFactor();
        if (loadFactor > 0.7) {
            reHash();
        }
    }

    public int get(String key) throws Exception {
        // Hash key
        // Search if key is in the list of the hash
        int hashedKey = getHash(key);
        for (KeyValue kv : table[hashedKey]) {
            if (kv.key == key) {
                return kv.value;
            }
        }
        throw new RuntimeException("Key '" + key + "' not found");
    }

    public void delete(String key) throws Exception {
        // Hash key
        // Search if key is in the list of the hash
        // Remove
        // If list is empty update populated and loadFactor
        int hashedKey = getHash(key);
        for (int i = 0; i < table[hashedKey].size(); i++) {
            KeyValue kv = table[hashedKey].get(i);
            if (kv.key == key) {
                table[hashedKey].remove(i);
                if (table[hashedKey].isEmpty()) {
                    populated--;
                    updateLoadFactor();
                }
                return;
            }
        }
        throw new RuntimeException("Key '" + key + "' not found");
    }




}