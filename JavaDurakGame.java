import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;




class JavaDurakGame
{

  private static final String FilePathName = "/home/zeo57/Desktop/Stupid/Data.txt";

  public static void main(String[] args)
  {

          getFirsPlayerCardArray();

  }

    public static String[] FileRead()
    {
      int i = 0,h =0;
        String [] LinesArray;
        LinesArray = new String[2];
        try (BufferedReader br = new BufferedReader(new FileReader(FilePathName)))
        {

			  String sCurrentLine;

			  while ((sCurrentLine = br.readLine()) != null)
        {

            LinesArray[i] =(sCurrentLine);
            h= h+1;// h means lines
          i++;
        }

		    } catch (IOException e)
         {
			e.printStackTrace();
		    }

        //reading file change to char
        return LinesArray;
	}


    public static  char getFirsPlayerCardArray()
    {
        char TrumpCard =' ';

        String[] testing = FileRead();
         System.out.println(Arrays.toString(testing));
         System.out.println(testing[0]);
         System.out.println(testing[1]);


         return TrumpCard;
    }


}
