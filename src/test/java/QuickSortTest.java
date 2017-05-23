import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by kushalkanavi on 5/22/17.
 */
public class QuickSortTest {

    @Test
    public void IntQuickSortTest(){
            QuickSort intquicksort = new QuickSort(SortType.ASCENDING);
            int[] array = {7,3,8,2,9,6,1,0,4,5};
            int len = array.length;
            array = intquicksort.Sort(array,0,len-1);
            Assert.assertEquals(0,array[0]);
            Assert.assertEquals(9,array[array.length - 1]);
    }

    @Test
    public void StringQuickSortTest(){
        QuickSort stringquicksort = new QuickSort(SortType.ASCENDING);
        String[] array = {"HI","HOW","ARE","YOU","DOING"};
        int len = array.length;
        array = stringquicksort.Sort(array,0,len-1);
        Assert.assertEquals("ARE",array[0]);
        Assert.assertEquals("YOU",array[len - 1]);
    }

    @Test
    public void FloatQuickSort() throws Exception{
        QuickSort floatquicksort = new QuickSort(SortType.ASCENDING);
        float[] array = {8f,9f,2f,4f,7f,1f,5f,3f,6f};
        array = floatquicksort.Sort(array,0,(array.length-1));
        Assert.assertEquals(1f,array[0],0);
        Assert.assertEquals(9f,array[array.length - 1],array.length - 1);
    }

    /*@Test
    public void FileQuickSortTest() throws Exception{
        QuickSort filesort = new QuickSort(SortType.DESCENDING);
        InputStream is = null;
        try {
            is = QuickSortTest.class.getClassLoader().getResourceAsStream("Words.txt");
            List<String> words = filesort.Sort(is,0,26);
            int len = words.size();
            //Assert.assertEquals("A",words.get(0));
            //Assert.assertEquals("Z",words.get(len-1));
            for (int i=0;i<len;++i){
                System.out.println(words.get(i));
            }
        }
        finally {
            if (is != null) {
                is.close();
            }
        }
    }*/
}
