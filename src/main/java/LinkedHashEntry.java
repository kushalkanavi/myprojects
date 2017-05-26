/**
 * Created by kushalkanavi on 5/24/17.
 */
public class LinkedHashEntry {
    int key;
    String value;
    LinkedHashEntry next;

    /* Constructor */
    LinkedHashEntry(int key, String value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
