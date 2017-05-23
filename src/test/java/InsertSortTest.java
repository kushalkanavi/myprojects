import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by kushalkanavi on 5/20/17.
 */
public class InsertSortTest {

    @Test
    public void IntInsertionSort(){
        InsertSort intinsertsort = new InsertSort(SortType.ASCENDING);
        int[] array = {8,9,2,4,7,1,5,3,6};
        array = intinsertsort.Sort(array);
        Assert.assertEquals(1,array[0]);
        Assert.assertEquals(9,array[array.length - 1]);
    }

    @Test
    public void StringInsertionSort(){
        InsertSort Stringinsertsort = new InsertSort(SortType.ASCENDING);
        String[] Strarray = {"HI","HOW","ARE","YOU","DOING"};
        Strarray = Stringinsertsort.Sort(Strarray);

        Assert.assertEquals("ARE",Strarray[0]);
        Assert.assertEquals("YOU",Strarray[Strarray.length - 1]);

    }

    @Test
    public void FloatInsertionSort(){
        InsertSort floatinsertsort = new InsertSort(SortType.DESCENDING);
        Float[] array = {8f,9f,2f,4f,7f,1f,5f,3f,6f};
        array = floatinsertsort.Sort(array);
        Assert.assertEquals(9f,array[0],0);
        Assert.assertEquals(1f,array[array.length - 1],array.length - 1);
    }

    @Test
    public void FileInsertSortTest() throws Exception{
        InsertSort filesort = new InsertSort(SortType.ASCENDING);
        InputStream is = null;
        try {
            is = InsertSortTest.class.getClassLoader().getResourceAsStream("Words.txt");
            List<String> words = filesort.Sort(is);
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
