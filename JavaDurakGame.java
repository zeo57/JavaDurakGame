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

      // temp lines down
      char TrumpCard = GetTrumpCard();
      System.out.println(TrumpCard);
      System.out.println(FindVerticalLine(1));
      System.out.println(FileLinesCount());
      System.out.println(OffencePlayerCards(1, FindVerticalLine(1)));
      System.out.println(DefencePlayerCards(1, FindVerticalLine(1)));
      System.out.println((StringLineConverterToCharArray(DefencePlayerCards(1, FindVerticalLine(1)))));
      System.out.println(branchIfPlayerHaveNonTrumpCard((StringLineConverterToCharArray(DefencePlayerCards(1, FindVerticalLine(1)))), TrumpCard) );

  }

    public static String[] FileRead()
    {
        int lineNumber = FileLinesCount();
        int i = 0;
        String [] linesArray;
        linesArray = new String[lineNumber];
        try (BufferedReader br = new BufferedReader(new FileReader(FilePathName)))
        {

			  String sCurrentLine;

			  while ((sCurrentLine = br.readLine()) != null)
        {

            linesArray[i] =(sCurrentLine);
            i++;

        }

		    } catch (IOException e)
         {
			e.printStackTrace();
		    }

        return linesArray;
	    }


      public static int FileLinesCount()
      {

        int numberOfLines = 0;

          try (BufferedReader br = new BufferedReader(new FileReader(FilePathName)))
          {

             while ((br.readLine()) != null)
            {
              numberOfLines++;

            }

          } catch (IOException e)
           {
              e.printStackTrace();
           }


          return numberOfLines;
        }









    public static  char GetTrumpCard()
    {

        String[] testing = FileRead();
        char TrumpCard = testing[0].charAt(0);

        return TrumpCard;
    }

    public static int FindVerticalLine(int lineNumber)
    {
        String[]  Array = FileRead();
        int verticalLinePosition = (Array[lineNumber].indexOf("|"));

        return verticalLinePosition;
    }





    public static String OffencePlayerCards(int lineNumber, int verticalLinePosition)
    {
        String[] array = FileRead();
        String loadingArray;

        loadingArray =  array[lineNumber].substring(0, (array[lineNumber].length()-(verticalLinePosition + 2)));

        return loadingArray;
    }




    public static String DefencePlayerCards(int lineNumber, int verticalLinePosition)
      {
        String[] array = FileRead();
        String loadingArray;

        loadingArray =  array[lineNumber].substring(verticalLinePosition + 2 , array[lineNumber].length());

        return loadingArray;
      }


    public static char[] StringLineConverterToCharArray(String lineOfStringWicthHaveTobeConverted)
    {

        if (lineOfStringWicthHaveTobeConverted == null)
        {
            return null;
        }

        int lengthOfString = lineOfStringWicthHaveTobeConverted.length();
        char[] charArray = new char [lengthOfString];

        for (int i = 0; i < lengthOfString ; i++)
        {
            charArray[i] = (lineOfStringWicthHaveTobeConverted.charAt(i));
            //System.out.print(charArray[i]);//convert array to char in other for using purpose lululululul -.-
        }

        return charArray;

     }




     public static int branchIfPlayerHaveNonTrumpCard(char[] charArray, char TrumpCard)
     {
          int cardsNumber = 0, trumpCardVariableCount = 0;






          for (int i = 0 ; i < charArray.length; i++)
          {
              if(charArray[i] != ' ')
              {
                  if  (charArray[i] == TrumpCard)
                  {
                      trumpCardVariableCount ++;
                      cardsNumber ++;
                  };
                  if (charArray[i] != TrumpCard)
                  {
                    cardsNumber ++;
                  }
              }

          }

          return  ((cardsNumber/2) - trumpCardVariableCount);
     }


     public static void findLowestOfencePlayerCard(int nonTrumpcard)
     {
        if(nonTrumpcard == 0)
        {

        }

        if (nonTrumpcard != 0)
        {

        }
     }


     //static method optimize







}
