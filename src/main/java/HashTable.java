/**
 * Created by kushalkanavi on 5/24/17.
 */
public class HashTable {
    private int TABLE_SIZE;
    private int size;
    private LinkedHashEntry[] table;

    public HashTable(int ts) {
        size = 0;
        TABLE_SIZE = ts;
        table = new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public void insert(String value) {
        int hash = (myhash(value.hashCode()) % TABLE_SIZE);

        if (table[hash] == null)
            table[hash] = new LinkedHashEntry(value);
        else
        {
            LinkedHashEntry entry = table[hash];
            while (entry.next != null && !(entry.value.equals(value)))
                entry = entry.next;
            if (entry.value.equals(value))
                entry.value = value;
            else
                entry.next = new LinkedHashEntry(value);
        }
        size++;
    }

    public String get(String value) {
        int hash = (myhash( value.hashCode() ) % TABLE_SIZE);
        if (table[hash] == null)
            return null;
        else
        {
            LinkedHashEntry entry = table[hash];
            while (entry != null && !(entry.value.equals(value)))
                entry = entry.next;
            if (entry == null)
                return null;
            else
                return entry.value;
        }
    }

    public void remove(String value) {
        int hash = (myhash( value.hashCode() ) % TABLE_SIZE);
        if (table[hash] != null)
        {
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];
            while (entry.next != null && !(entry.value.equals(value)))
            {
                prevEntry = entry;
                entry = entry.next;
            }
            if (entry.value.equals(value))
            {
                if (prevEntry == null)
                    table[hash] = entry.next;
                else
                    prevEntry.next = entry.next;
                size--;
            }
        }
    }

    public void printHashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("\nBucket " + (i ) + " : ");
            LinkedHashEntry entry = table[i];
            while (entry != null) {
                System.out.print(entry.value + " ");
                entry = entry.next;
            }
        }
        System.out.println();
    }

    

    private int myhash(int x ) {
        int hashVal = x;
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return hashVal;
    }
}