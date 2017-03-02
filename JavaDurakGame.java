import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

class JavaDurakGame
{
  private static final String FilePathName = "/home/zeo57/Desktop/Stupid/Data.txt"; //Linux directory 

  public static void main(String[] args)
  {
      char TrumpCard = GetTrumpCard();
      System.out.print(TrumpCard);
      System.out.println(FindVerticalLine(1));
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
          } 
	    catch (IOException e)
         {
	     e.printStackTrace();
         }

   
          System.out.println(LinesArray[1].substring(kintamasis, LinesArray[1].length()));
          
	    return LinesArray;
	}


    public static  char GetTrumpCard()
    {
        String[] testing = FileRead();
        char TrumpCard = testing[0].charAt(0);

        return TrumpCard;
    }

    public static int FindVerticalLine(int LineNumber)
    {
        String[]  Array = FileRead();
        int kintamasis = (Array[LineNumber].indexOf("|"));

        return kintamasis;
    }



/*
    public static String[] OffencePlayerCards()
    {

    }
*/







}

