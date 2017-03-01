import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;




class JavaDurakGame
{

  private static final String FilePathName = "/home/zeo57/Desktop/Stupid/Data.txt";
































  public static void main(String[] args){
      String[] someNumbers = FileRead();
      //do whatever you want with them...
      System.out.println(Arrays.toString(someNumbers));






  }

    public static String[] FileRead()
    {
      int i = 0;
        String [] LinesArray;
        LinesArray = new String[10];
        try (BufferedReader br = new BufferedReader(new FileReader(FilePathName)))
        {

			  String sCurrentLine;

			  while ((sCurrentLine = br.readLine()) != null)
        {

            LinesArray[i] =(sCurrentLine);
          i++;
        }

		    } catch (IOException e)
         {
			e.printStackTrace();
		    }



        return LinesArray;
	}












}
