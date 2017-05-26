import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by kushalkanavi on 5/23/17.
 */
public class CSVFile {
    public void csvfile(String filename)throws IOException {
        File file = new File(filename);
        Scanner input = new Scanner(file);
        String row = input.nextLine();
        String[] columnHeader = row.split(",");
        int nofcolumns = columnHeader.length;
        while (input.hasNextLine()){
            row = input.nextLine();
            String [] column = row.split(",");

            for (int i=0;i<nofcolumns;++i){
                System.out.println(columnHeader[i]+" :"+column[i]);
            }
            System.out.println();
        }
        input.close();
    }
}

/**
 * Name : Alex
 * Sex : M
 * Age : 41
 * Height : 74
 * Weight : 170
 *
 * Name: Bert
 * ...
 * ...
 * ...
 */