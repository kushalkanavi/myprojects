import java.io.FileNotFoundException;

/**
 * Created by kushalkanavi on 5/19/17.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
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

        ht.printHashTable();

        ht.remove("work");

        ht.printHashTable();

        //System.out.println(ht.get(45));
    }
}