import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kushalkanavi on 5/20/17.
 */
public class QuickSort {
    private SortType type;

    public QuickSort(SortType type) {
        this.type = type;
    }

    public int[] Sort(int arr[], int low, int high) {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            Sort(arr, low, pi-1);
            Sort(arr, pi+1, high);
        }
        return arr;
    }

    public int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<=high-1; j++)
        {
            if (type == SortType.ASCENDING){
                if (arr[j] <= pivot)
                {
                    i++;

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            else{
                if (arr[j] >= pivot)
                {
                    i++;

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public String[] Sort(String arr[], int low, int high) {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            Sort(arr, low, pi-1);
            Sort(arr, pi+1, high);
        }
        return arr;
    }

    public int partition(String arr[], int low, int high) {
        String pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<=high-1; j++)
        {
            if (type == SortType.ASCENDING){
                if (arr[j].compareTo(pivot) <= 0)
                {
                    i++;

                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            else{
                if (arr[j].compareTo(pivot) >= 0)
                {
                    i++;

                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        String temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public float[] Sort(float arr[], int low, int high) {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            Sort(arr, low, pi-1);
            Sort(arr, pi+1, high);
        }
        return arr;
    }

    public int partition(float arr[], int low, int high) {
        float pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<=high-1; j++)
        {
            if (type == SortType.ASCENDING){
                if (arr[j] <= pivot)
                {
                    i++;

                    float temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            else{
                if (arr[j] >= pivot)
                {
                    i++;

                    float temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        float temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public List<String> Sort(InputStream is,int low,int high) throws IOException {
        List<String> elements = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                elements.add(word);
            }
        }
        try {
            is = QuickSort.class.getClassLoader().getResourceAsStream("Words.txt");
            //List<String> words = QuickSort.Sort(is);
            //int len = words.size();

            if (low < high)
            {
                int pi = partition(elements, low, high);

                Sort(is, low, pi-1);
                Sort(is, pi+1, high);
            }
        }
        finally {
            if (is != null) {
                is.close();
            }
        }
        return elements;
    }

    public int partition(List<String> elements, int low, int high) {
        String pivot = elements.get(high);
        int i = (low-1);
        for (int j=low; j<=high-1; j++)
        {
            if (type == SortType.ASCENDING){
                if (elements.get(j).compareTo(pivot) <= 0)
                {
                    i++;

                    String temp = elements.get(i);
                    elements.remove(i);
                    elements.add(i,(elements.get(j)));
                    elements.remove(j);
                    elements.add(j,temp);
                }
            }
            else{
                if (elements.get(j).compareTo(pivot) >= 0)
                {
                    i++;

                    String temp = elements.get(i);
                    elements.remove(i);
                    elements.add(i,(elements.get(j)));
                    elements.remove(j);
                    elements.add(j,temp);
                }
            }
        }

        String temp = elements.get(i+1);
        elements.remove(i+1);
        elements.add((i+1),(elements.get(high)));
        elements.remove(high);
        elements.add(high,temp);

        return i+1;
    }
}
