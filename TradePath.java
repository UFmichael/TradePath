//Objective: To be a class that assists and allows the PlayPath program to run. This class will give values to the program as needed.
//Michael Yao
//Date Modified: January 31st, 2020

import java.util.Random;

public class TradePath
{
   private int event;
   private double balance = 20000;
   Random newNum = new Random();
   
   //Mutators: None, Data fields won't be changed during the run of the program.
   //Accessors
   //Objective: Get the value held in the provade data field of balance
   //Return: double
   //Parameter: void
   public double getBal()
   {
      return balance;
   }
   
   //Objective: To return the value of the price given the choice of the user.
   //Return: double
   //Parameter: int
   public double getPrice(int i)
   {
      if(i == 1)
      {
         return 3000.00;
      }
      else if(i == 2)
      {
         return 5000.00;
      }
      else if(i == 3)
      {
         return 7000.00;
      }
      else
      {
         return 0.00;
      }
   }
   
   //Objective: To return a random number to be used as the amount for the loss in the situation.
   //Return: double
   //Parameter: void
   public double generateLoss()
   {
      double loss;
      
      loss = newNum.nextInt(600000)+50000;
      loss = loss/100;
      return loss;
   }
   
   //Objective: To return a random number to be used as the amount for the gain in the situation.
   //Return: double
   //Parameter: void
   public double generateGain()
   {
      double gain;
      
      gain = newNum.nextInt(500000)+5000;
      gain = gain/100;
      return gain;
   }
   
   //Objective: To return a random number to be used as the choice to decide the situation for that run.
   //Return: int
   //Parameter: void
   public int roadFork()
   {
      return newNum.nextInt(4);
   }
}