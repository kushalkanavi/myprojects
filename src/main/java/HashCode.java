/**
 * Created by kushalkanavi on 5/23/17.
 */
public class HashCode {

    int key;
    String value;
    HashCode next;

        public int getKey(){
            return key;
    }

    public void setValue(String v){
            this.value=v;
    }

    public String  getVaule(){
        return value;
    }

    public int hashfunction(int key){

        key = key % 10;
        return key;
    }

    HashCode head = null;
    HashCode current = null;
    HashCode temp = null;
    public HashCode put(int k,String v){

            if(head == null){
                HashCode temp = new HashCode();
                temp.key = k;
                temp.value = v;
                temp.next = null;
                head = current = temp;
            }
            else{
                HashCode temp = new HashCode();
                temp.key = k;
                temp.next = null;
                current.next = temp;
                current = temp;
            }
            return temp;
    }

    public String get(int k){
        if (head !=null);
        return this.value;
    }
}