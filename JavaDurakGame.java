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
      //System.out.println(FindVerticalLine(1));
      //System.out.println(FileLinesCount());
      //System.out.println(OffencePlayerCards(1, FindVerticalLine(1)));
      //System.out.println(DefencePlayerCards(1, FindVerticalLine(1)));
      //System.out.println((StringLineConverterToCharArray(OffencePlayerCards(1, FindVerticalLine(1)))));
      //System.out.println(branchIfPlayerHaveNonTrumpCard((StringLineConverterToCharArray(OffencePlayerCards(1, FindVerticalLine(1)))), TrumpCard) );

      int  minPosition =(getMinValue((StringLineConverterToCharArray(OffencePlayerCards(1, FindVerticalLine(1)))), TrumpCard));
      output( minPosition, (StringLineConverterToCharArray(OffencePlayerCards(1, FindVerticalLine(1)))) );
      //System.out.println(output(minPosition , (StringLineConverterToCharArray(OffencePlayerCards(1, FindVerticalLine(1))))));







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

        loadingArray =  array[lineNumber].substring(0, ((array[lineNumber].length()-1) -(verticalLinePosition + 2)));

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

            getMinValue((StringLineConverterToCharArray(OffencePlayerCards(1, FindVerticalLine(1)))), GetTrumpCard());


        }
     }



     public static int getMinValue(char[] playerArray, char TrumpCard)
      {
        int [] rankIntArray;
        String [] rankStringArray;

        int cardsNumber = 0, minimumValue = 14, minimumValuePositionInArray = 0;
        rankIntArray = new int[playerArray.length];
        rankStringArray = new String[playerArray.length];



         for (int i = 0 ; i < playerArray.length; i++)
         {
             if(playerArray[i] != ' ')
             {

               cardsNumber ++;
             }
         }


         for (int i = 0 ; i < playerArray.length; i++)
         {
            System.out.print(playerArray[i]);
         }

          for (int i = 0; i < playerArray.length; i++)
          {
             rankStringArray[i]  = String.valueOf(playerArray[i]);

          }


          for (int i = 0; i <= cardsNumber+2; i = i+3)
          {

            if (!rankStringArray[i].equals(String.valueOf(TrumpCard)) && (!rankStringArray[i].equals(String.valueOf(' ')) ))
                {

                  if (rankStringArray[i+1].equals("A"))
                  {
                   rankStringArray[i+1] = "14";
                  }


                  if (rankStringArray[i+1].equals("K"))
                  {
                   rankStringArray[i+1] = "13";
                  }

                  if(rankStringArray[i+1].equals("Q"))
                  {
                    rankStringArray[i+1] = "12";
                  }

                  if(rankStringArray[i+1].equals("J"))
                  {
                    rankStringArray[i+1] = "11";
                  }

                  if(rankStringArray[i+1].equals("T"))
                  {
                   rankStringArray[i+1] = "10";
                  }


               }
            }


            for (int i = 0; i <= cardsNumber+2; i = i+3)
              {
              if (!rankStringArray[i].equals(String.valueOf(TrumpCard)) && (!rankStringArray[i].equals(String.valueOf(' ')) ))
                 {
                    if ((Integer.parseInt(rankStringArray[i+1])) <= minimumValue)
                        {
                            minimumValue = Integer.parseInt(rankStringArray[i+1]);
                            minimumValuePositionInArray = i + 1;
                        }
                 }

               }









        System.out.println();
        for (int i = 0; i < playerArray.length; i++)
        {
          System.out.print(rankStringArray[i]);
        }

    return minimumValuePositionInArray;
}

    public static char SimbolChanger(char simbol)
    {
      char simbolReturn = simbol;

      if(simbol == ('C'))
      {
          simbolReturn = '♣';
      }
      if(simbol == ('D'))
      {
          simbolReturn = '♦';
      }
      if(simbol == ('H'))
      {
          simbolReturn ='♥';
      }
      if(simbol == ('S'))
      {
          simbolReturn = '♠';
      }
        return simbolReturn;
    }


    public static void output(int position,  char[] array )
    {
        int gameVariable = 1, TurnVariable = 1; //line counting next quest

        System.out.println("\n");
        System.out.println("### Game " + gameVariable);
        System.out.println("Turn " + TurnVariable);
        System.out.print("Atack with " + SimbolChanger(array[position-1]));
        System.out.println(" " + array[position]);



    }









     //static method optimize







}
