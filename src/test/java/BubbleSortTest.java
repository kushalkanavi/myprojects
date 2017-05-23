import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kushalkanavi on 5/19/17.
 */
public class BubbleSortTest {

    @Test
    public void IntBubbleSortTest() throws Exception {
        int[] array = {5, 3, 6, 1, 8, 2, 9, 4, 7};
        BubbleSort sorter = new BubbleSort(SortType.DESCENDING);
        array = sorter.sort(array);
        Assert.assertEquals(9, array[0]);
        Assert.assertEquals(1, array[array.length - 1]);
    }
    @Test
    public void CharBubbleSortTest() throws Exception {
        char[] arr = {'H','A','D','F','O','W'};
        BubbleSort charsort = new BubbleSort(SortType.DESCENDING);
        arr = charsort.sort(arr);
        Assert.assertEquals('W',arr[0]);
        Assert.assertEquals('A',arr[arr.length - 1]);
    }
    @Test
    public void StringBubbleSortTest() throws Exception {
        String[] strarr = {"HI","HOW","ARE","YOU","DOING"};
        BubbleSort stringsort = new BubbleSort(SortType.DESCENDING);
        strarr = stringsort.sort(strarr);
        Assert.assertEquals("YOU",strarr[0]);
        Assert.assertEquals("ARE",strarr[strarr.length - 1]);

        String[] strarr2 = {"A","BA","AB","B"};
        BubbleSort stringsort2 = new BubbleSort(SortType.ASCENDING);
        strarr2 = stringsort2.sort(strarr2);
        Assert.assertEquals("A",strarr2[0]);
        Assert.assertEquals("BA",strarr2[strarr2.length - 1]);
    }

    @Test
    public void FloatBubbleSort() throws Exception{
        BubbleSort floatbubblesort = new BubbleSort(SortType.ASCENDING);
        float[] array = {8f,9f,2f,4f,7f,1f,5f,3f,6f};
        array = floatbubblesort.sort(array);
        Assert.assertEquals(1f,array[0],0);
        Assert.assertEquals(9f,array[array.length - 1],array.length - 1);
    }

    @Test
    public void FileBubbleSortTest() throws Exception{
     BubbleSort filesort = new BubbleSort(SortType.DESCENDING);
     InputStream is = null;
     try {
         is = BubbleSortTest.class.getClassLoader().getResourceAsStream("Words.txt");
         List<String> words = filesort.sort(is);
         int len = words.size();
         Assert.assertEquals("A",words.get(0));
         Assert.assertEquals("Z",words.get(len-1));
     }
     finally {
         if (is != null) {
             is.close();
         }
     }
    }
}