import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
class JavaDurakGame1
{

  private static final String FilePathName = "/home/zeo57/Desktop/Stupid/durakas/Data.txt";






public static void main(String[] args)
{
  System.out.println(FileRead());
  System.out.println(PlayerOneCards(1));
  System.out.println(PlayerTwoCards(1));
  FindLowestCard(PlayerOneCards(1),"");
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



public static String[] FileRead()
{
    int numberOfLines = FileLinesCount();
    int i = 0;
    String [] linesArray;
    linesArray = new String[numberOfLines];
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
public static char GetTrumpCard()
{
  String[] testing = FileRead();
  char TrumpCard = testing[0].charAt(0);

  return TrumpCard;
}


public static int ConverterStringToInt(String cardRank)
{
   int cardRankInt = 0 ;

  if (cardRank.equals("A"))
    {
      cardRankInt =14;
    }
  if (cardRank.equals("K"))
    {
      cardRankInt = 13;
    }
  if(cardRank.equals("Q"))
    {
      cardRankInt = 12;
    }
  if(cardRank.equals("J"))
    {
      cardRankInt = 11;
    }
  if(cardRank.equals("T"))
    {
      cardRankInt = 10;
    }

    if (cardRank.equals("2"))
      {
        cardRankInt = 2;
      }
    if (cardRank.equals("3"))
      {
        cardRankInt = 3;
      }
    if(cardRank.equals("4"))
      {
        cardRankInt = 4;
      }
    if(cardRank.equals("5"))
      {
        cardRankInt = 5;
      }
    if(cardRank.equals("6"))
      {
        cardRankInt = 6;
      }



      if (cardRank.equals("7"))
        {
          cardRankInt = 7;
        }
      if (cardRank.equals("8"))
        {
          cardRankInt = 8;
        }
      if(cardRank.equals("9"))
        {
          cardRankInt = 9;
        }



    return cardRankInt;
}




  public static String PlayerOneCards(int LineNumber)
  {

    String[] testing = FileRead();
    int verticalLine = testing[LineNumber].indexOf("|");
    String p1Cards = testing[LineNumber];
    p1Cards = p1Cards.substring(0,verticalLine);
    p1Cards = p1Cards.replace(" ","");

    return p1Cards;
  }

  public static String PlayerTwoCards(int LineNumber)
  {
    String[] testing = FileRead();

    int verticalLine = testing[LineNumber].indexOf("|");
    String p2Cards = testing[LineNumber];
    p2Cards = p2Cards.substring(verticalLine + 1, testing[LineNumber].length());
    p2Cards = p2Cards.replace(" ","");
    return p2Cards;
  }


















  public static String FindLowestCard(String playerCard, String lastCard)
  {   int h = 0;
      String temporary = playerCard;
      String temp;
      int min = 14;
      int minas;
      int trumCardss = 0, nonTrumCard = 0;


      if lastCard.substring
      







        for (int i = 0; i < playerCard.length();i = i+2)
        {
          temp = temporary.substring(i,  i+1);
            if (!(String.valueOf(GetTrumpCard())).equals(temp))
            {
              nonTrumCard ++;

            }
            else
            {
              trumCardss++;
            }
        }
System.out.println(nonTrumCard + " " + trumCardss);
        if for()
      return playerCard;
  }








  public static void output(int gameVariable, int TurnVariable, boolean stop, String move, int value, int countT, boolean firstmove  )
  {
      System.out.println("### Game " + gameVariable);
      System.out.println("/n");
      System.out.println("Turn " + TurnVariable);
      while(stop == true)
      {
          if (firstmove == true)
          {
            System.out.println("Attack with" + value);
          }
          if(move.equals("passig"))
          {
            System.out.println("Passing against " + value + " with"  + "WrappedArray(" + value +"): ");
          }
          if(move.equals("cantpassing"))
          {
            System.out.println("Cannot pass against" +  value + ":");
          }
          if(move.equals("Def") && (countT == 1))
          {
            System.out.println("Deffending against List("+  value   );
          }
          if((move.equals("Deff")) && (countT != 1))
          {
            System.out.println("Deffending against (" +  value   );
          }
          if ((move.equals("DeffSuccesfull")))
          {
              System.out.println("Deffended against");
          }



      }



  }











  public static void StateOutput(boolean  changedPlace)
  {
      System.out.println(": State[");

      System.out.println("trump: " + SimbolChanger(GetTrumpCard()));
      if(changedPlace == true)
      {
        System.out.println("o: P2 [" + P2 + "]");
        System.out.println("d: P1 [" + P1 + "]");
        System.out.println("t: " + t);
      }
      if(changedPlace == false)
      {
        System.out.println("o: P1 [" + P1 + "]");
        System.out.println("d: P2 [" + P2 + "]");
        System.out.println("t: " + t);
      }




      System.out.println("]");
  }



}

        
