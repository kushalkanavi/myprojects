/**
 * Created by kushalkanavi on 5/19/17.
 */
public class Main {

    public static void main(String[] args){
        HashTable ht = new HashTable(10);

        ht.insert(11111,"Apple");
        ht.insert(3,"Ball");
        ht.insert(45,"Cat");
        ht.insert(65,"Dog");
        ht.insert(25,"Elephant");
        ht.insert(97,"Fish");
        ht.insert(10,"Goat");

        ht.printHashTable();

        ht.remove(65);

        ht.printHashTable();

        System.out.println(ht.get(45));
    }
}
