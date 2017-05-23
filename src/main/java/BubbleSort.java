import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kushalkanavi on 5/19/17.
 */
public final class BubbleSort {
    private SortType type;

    public BubbleSort(SortType type) {
        this.type = type;
    }

    public int[] sort(int[] array) {
        int len = array.length;
        for (int i=0;i<len;++i){
            for(int j=1;j<len - i;++j) {
                if (type == SortType.ASCENDING) {
                    if (array[j-1] > array[j]){
                        int temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                } else {
                    if (array[j-1] < array[j]){
                        int temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                }

            }
        }
        return array;
    }

    public char[] sort(char[] array){
        int len = array.length;
        for (int i=0;i<len;++i){
            for(int j=1;j<len - i;++j) {
                if (type == SortType.ASCENDING){
                    if (array[j-1] > array[j]){
                        char temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                }
                else{
                    if (array[j-1] < array[j]){
                        char temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
            }
        }
    }
        }
        return array;
    }

    public String[] sort(String[] array){
        int len = array.length;
        for (int i=0;i<len;++i){
            for (int j=1;j<len-i;++j){
                if (type == SortType.ASCENDING) {
                    if (array[j-1].compareTo(array[j])>0){
                        String temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                }
                else {
                    if (array[j-1].compareTo(array[j])<0){
                        String temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                }
            }
        }
        return array;
    }

    public float[] sort(float[] array){

        int len = array.length;
        for (int i=0;i<len;++i){
            for(int j=1;j<len - i;++j) {
                if (type == SortType.ASCENDING) {
                    if (array[j-1] > array[j]){
                        float temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                } else {
                    if (array[j-1] < array[j]){
                        float temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                }

            }
        }
        return array;
    }

    public List<String> sort(InputStream is) throws IOException {
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
        for (int i=0;i<len;++i) {
            for (int j = 1; j < len - i; ++j) {
                if (type == SortType.DESCENDING) {
                    if (elements.get(j - 1).compareTo(elements.get(j)) > 0) {
                        String temp = elements.get(j);
                        elements.remove(j);
                        elements.add(j, elements.get(j - 1));
                        elements.remove(j - 1);
                        elements.add((j - 1), temp);
                    }
                } else {
                    if (elements.get(j - 1).compareTo(elements.get(j)) < 0) {
                        String temp = elements.get(j);
                        elements.remove(j);
                        elements.add(j, elements.get(j - 1));
                        elements.remove(j - 1);
                        elements.add((j - 1), temp);
                    }
                }
            }
        }
        return elements;
    }
}