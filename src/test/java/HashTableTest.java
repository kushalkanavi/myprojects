import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kushalkanavi on 5/26/17.
 */
public class HashTableTest {

    @Test
    public void HashTest() throws Exception{
        HashTable ht = new HashTable(10);

        ht.insert("Apple");
        ht.insert("Ball");
        ht.insert("Cat");
        ht.insert("Dog");
        ht.insert("Elephant");
        ht.insert("Fish");
        ht.insert("Goat");
        ht.insert("GoatA");
        ht.insert("GoatB");
        ht.insert("GoatAA");

        Assert.assertEquals("Apple",ht.get("Apple"));
        Assert.assertEquals("Elephant",ht.get("Elephant"));
    }
}
