//Objective: To allow a user to play the trade path game that was specially designed for the create project. 
//Michael Yao
//Date Modified: Febuary 13th, 2020

import java.util.*;

public class PlayPath
{
   public static void main(String[]args)
   {
      String name, companyName, choiceString, wait;
      int choice = 0;
      int i;
      double price, myBal;
      Scanner input = new Scanner(System.in);
      TradePath myPath = new TradePath();
      boolean doesWork = false;
      char choosen = 0;
      double lossCover = 0;
      final int GIFT = 5000;
      String balance, number;
            
      System.out.println("Hello new trader! \nPlease enter in your name.");
      name = input.nextLine();
      System.out.println("Hello "+name+" I hope you can trade well. \nYou will now be starting a new trading company! \nPlease enter a name for your company.");
      companyName = input.nextLine();
      System.out.println("Congratulations "+name+" you are now the owner of "+companyName+".");
      
      myBal = myPath.getBal();
      balance = String.format("%.2f", myBal);
            
      System.out.println("To start, you currently have $"+balance+" as the amount of investments available for you to spend on your company. \nSpend it wisely!");
      System.out.println("\nYou were traveling down the path to the nearest town you meet another trader. \nThe trader offers to sell you an insurance policy for your goods.");
      System.out.println("If you would like to buy insurance on your company enter the integer: \n\t[1]  for the least expenisve coverage.(The price is $3000) \n\t[2]  for a normal coverage.(The price is $5000) \n\t[3]  for the most expensive coverage.(The price is $7000)  \n\t[4]  to not buy any insurance.(The price is $0)");
      
      
      doesWork = false;
      while(doesWork == false)
      {
         choiceString = input.nextLine();
         choosen = choiceString.charAt(0);
         if((int)choosen >= 49 && (int)choosen <= 52)
         {
            System.out.println("This is a valid insurance plan.");
            doesWork = true;
         }
         else
         {
            System.out.println("This is not a valid insurance plan. Please enter the kind of insurance you would like your company to have. \n1 for the least expenisve coverage, 2 for a normal coverage, 3 for the most expensive coverage, or 4 if you aren't buying any insurance.");
         }
      }
      
      choice = (int)choosen;
            
      if(choice == 49)
      {
         System.out.println("Congrats you have chosen the least expensive insurance coverage plan!");
         number = String.format("%.2f", myPath.getPrice(1));
         System.out.println("This insurance plan will cost $"+number);
         myBal = myBal - myPath.getPrice(1);
         balance = String.format("%.2f", myBal);
         System.out.println("After substracting the cost of your insurance plan from your balance you now have a balance of $"+balance);
      }
      else if(choice == 50)
      {
         System.out.println("Congrats you have chosen the normal insurance coverage plan!");
         number = String.format("%.2f", myPath.getPrice(2));
         System.out.println("This insurance plan will cost $"+number);
         myBal = myBal - myPath.getPrice(2);
         balance = String.format("%.2f", myBal);
         System.out.println("After substracting the cost of your insurance plan from your balance you now have a balance of $"+balance);
      }
      else if(choice == 51) 
      {
         System.out.println("Congrats you have chosen the most expensive insurance coverage plan!");
         number = String.format("%.2f", myPath.getPrice(3));
         System.out.println("This insurance plan will cost $"+number);
         myBal = myBal - myPath.getPrice(3);
         balance = String.format("%.2f", myBal);
         System.out.println("After substracting the cost of your insurance plan from your balance you now have a balance of $"+balance);
      }
      else
      {
         System.out.println("You have chosen no insurance plan. This may pose problems in the future.");
         number = String.format("%.2f", myPath.getPrice(4));
         System.out.println("This insurance plan will cost $"+number);
         myBal = myBal - myPath.getPrice(4);
         balance = String.format("%.2f", myBal);
         System.out.println("After substracting the cost of your insurance plan from your balance you now have a balance of $"+balance);
      }
      
      System.out.println("\nYou are now setting out on your first mission to buy and sell items. \nPlease note that you will be limited to 5 missions.");
      
      for(i=1; i<=5; i++)
      {
         boolean again = true;
         while(again == true)
         {
            System.out.println("\nWould you like your men to set out on a mission? \nEnter y/n \nAnything entered that isn't the letter y will be assumed to be n.");
            System.out.println("You have "+(6-i)+" missions left that you can go on.");
            choiceString = input.nextLine().toLowerCase();
            
            if(choiceString.equals("y"))
            {
               if(myPath.roadFork()==1)
               {
                  System.out.println("During your mission your men met a wealthy group of people and become good friends with them. \nAs a parting gift you are given $"+GIFT+" to help your company.");
                  myBal = myBal + (double)GIFT;
                  balance = String.format("%.2f", myBal);
                  System.out.println("Your new balance after the mission is $"+balance);
                  again = false;
               }
               else if(myPath.roadFork()==2)
               {
                  System.out.println("On the way to the city to trade, your men found that the path was blocked and had to return empty handed.");
                  again = false;
               }   
               else if(myPath.roadFork()==3)
               {
                  price = myPath.generateGain();
                  number = String.format("%.2f", price);
                  System.out.println("Your men successfully reached the destination and traded with the locals. You have gained "+number);
                  myBal = myBal + price;
                  balance = String.format("%.2f", myBal);
                  System.out.println("Your new balance after the mission is $"+balance);
                  again = false;
               }
               else
               {
                  System.out.println("Your men weren't careful and were raided by bandits during the trade mission.");
                  price = myPath.generateLoss();
                  number = String.format("%.2f", price);
                  System.out.println("You lost $"+number+" worth of goods.");
                  //Insurance protection effect
                  if(choice == 49)
                  {
                     lossCover = price/4;
                     number = String.format("%.2f", lossCover);
                     System.out.println("Because you chose the lease expensive insurance plan you are covered for $"+number+" \nThis about a fourth of the original loss!");
                     myBal = myBal - price + lossCover;
                     balance = String.format("%.2f", myBal);
                     System.out.println("Your new balance after the mission is $"+balance);
                  }
                  else if(choice == 50)
                  {
                     lossCover = price/2;
                     number = String.format("%.2f", lossCover);
                     System.out.println("Because you chose the normal insurance plan you are covered for $"+number+" \nThis about a half of the original loss!");
                     myBal = myBal - price + lossCover;
                     balance = String.format("%.2f", myBal);
                     System.out.println("Your new balance after the mission is $"+balance);
                  }
                  else if(choice == 51)
                  {
                     lossCover = (price*3)/4;
                     number = String.format("%.2f", lossCover);
                     System.out.println("Because you chose the most expensive insurance plan you are covered for $"+number+" \nThis is about three fourths of the original loss!");
                     myBal = myBal - price + lossCover;
                     balance = String.format("%.2f", myBal);
                     System.out.println("Your new balance after the mission is $"+balance);
                  }
                  else
                  {
                     number = String.format("%.2f", price);
                     System.out.println("Because you choose not to buy an insurance plan there is no coverage and you lose the full $"+number);
                     myBal = myBal - price;
                     balance = String.format("%.2f", myBal);
                     System.out.println("Your new balance after the mission is $"+balance);
                  }
                  again = false;             
               }
            }
            else
            {
               again = false;
               i = 20;
            }
         }
         
      }
      //end of the for the mission loop
      System.out.println("\nYou are done! The trade path has ended. \nEnter anything to see your results.");
      wait = input.nextLine();
      balance = String.format("%.2f", myBal);
      System.out.println("You have ended the game with $"+balance+" worth of investments left in your company.");
      if(myBal>=20000)
      {
         balance = String.format("%.2f", myBal-20000);
         System.out.println("You have gained $"+balance+" while playing this game! Great job! \nI hope you have a nice day! *v*");
      }
      else
      {
         balance = String.format("%.2f", 20000-myBal);
         System.out.println("You have lost $"+balance+" while playing this game. Better luck next time!");
      }
   }
}