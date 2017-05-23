import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kushalkanavi on 5/20/17.
 */
public class InsertSort {
    private SortType type;

    public InsertSort(SortType type) {
        this.type = type;
    }

    public int[] Sort(int[] array){
        int len = array.length;
        for (int i=1; i<len; ++i)
        {
            int key = array[i];
            int j=i-1;

            if (type == SortType.ASCENDING){
                while (j>=0 && array[j] > key){
                    array[j+1] = array[j];
                    j=j-1;
                }
            }
            else{
                while (j>=0 && array[j] < key){
                    array[j+1] = array[j];
                    j=j-1;
                }
            }

            array[j+1]=key;
        }
        return array;
    }

    public String[] Sort(String[] array){
        int len = array.length;
        for (int i=1; i<len; ++i)
        {
            String key = array[i];
            int j=i-1;

            if (type == SortType.ASCENDING) {
                while (j >= 0 && array[j].compareTo(key) > 0) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
            }
            else {
                while (j >= 0 && array[j].compareTo(key) < 0) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
            }
            array[j+1]=key;
        }
         return array;
    }

    public Float[] Sort(Float[] array){
        int len = array.length;
        for (int i=1; i<len; ++i)
        {
            float key = array[i];
            int j=i-1;

            if (type == SortType.ASCENDING){
                while (j>=0 && array[j] > key){
                    array[j+1] = array[j];
                    j=j-1;
                }
            }
            else{
                while (j>=0 && array[j] < key){
                    array[j+1] = array[j];
                    j=j-1;
                }
            }

            array[j+1]=key;
        }
        return array;
    }

    public List<String> Sort(InputStream is) throws IOException {
        List<String> elements = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                elements.add(word);
            }
        }

        int len = elements.size();
        for (int i=1; i<len; ++i)
        {
            String key = elements.get(i);
            int j=i-1;

            if (type == SortType.ASCENDING) {
                while (j >= 0 && elements.get(j).compareTo(key) > 0) {
                    elements.remove(j+1);
                    elements.add((j+1),(elements.get(j)));
                    j = j - 1;
                }
            }
            else {
                while (j >= 0 && elements.get(j).compareTo(key) < 0) {
                    elements.remove(j+1);
                    elements.add((j+1),(elements.get(j)));
                    j = j - 1;
                }
            }
            elements.remove(j+1);
            elements.add((j+1),key);
        }
        return elements;
    }
}
