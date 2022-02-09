package Controller;

import Model.Entity.Gift;
import Model.Entity.Sweet;
import Model.Exceprion.ImpossibleAmountOfSweets;
import Model.Logic.SantaClause;
import Util.Serializable;
import Util.SweetsCreator;
import Util.Initializator;
import View.Printer;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter amount of sweets: ");

            int sweetsAmount = in.nextInt();
            List<Sweet> sweets = SweetsCreator.create(sweetsAmount);
            Initializator.init(sweets);
            Gift gift = new Gift(sweets);
            int count = 0;
            String menu = "\n\t\tMenu: " +
                    "\n1. Print gift;" +
                    "\n2. Sort gift by price and print;" +
                    "\n3. Sort gift by name and print;" +
                    "\n4. Sort gift by weight and print;" +
                    "\n5. Print info about the most expensive sweet in gift;" +
                    "\n6. Print weight and price of the gift;" +
                    "\n7. Serializable;" +
                    "\n8. Deserializable;" +
                    "\n9. Exit;\n";
            String msg="";
            boolean flag = true;
            while(flag) {

                //Printer.printInFile(menu);
                Printer.print(menu);
                int choice = in.nextInt();

                switch (choice){
                    case 1:
                        msg = "\n\n\tInfo about the gift:\n " + gift;
                        Printer.printInFile(msg,count);
                        Printer.print(msg);
                        count++;
                        break;
                    case 2:
                        SantaClause.sortedByPrice(gift);
                        msg =  "\n\n\tSorted gift by price:" + gift;
                        Printer.printInFile(msg,count);
                        Printer.print(msg);
                        count++;
                        break;
                    case 3:
                        SantaClause.sortedByName(gift);
                        msg = "\n\n\tSorted gift by name:" + gift;
                        Printer.printInFile(msg,count);
                        Printer.print(msg);
                        count++;
                        break;
                    case 4:
                        SantaClause.sortedByWeight(gift);
                        msg = "\n\n\tSorted gift by weight:" + gift;
                        Printer.printInFile(msg,count);
                        Printer.print(msg);
                        count++;
                        break;
                    case 5:
                        msg = "\n\n\tInfo about the most expensive sweet in gift: \n" +
                                SantaClause.findMostExpensiveSweetness(gift)+"\n";
                        Printer.printInFile(msg,count);
                        Printer.print(msg);
                        count++;
                        break;
                    case 6:
                        msg = "\n\nGift weight: " + SantaClause.calculateGiftsWeight(gift) + "grams" +
                                "\nGift price: " + SantaClause.calculateGiftsPrice(gift) + "$\n";
                        Printer.printInFile(msg,count);
                        Printer.print(msg);
                        count++;
                        break;
                    case 7:
                        Serializable.serializable(sweets);
                        count++;
                        break;
                    case 8:
                        //sweets.clear();
                        Serializable.deserializable(sweets);
                        count++;
                        break;
                    case 9:
                        flag = false;
                        break;

                    default:
                        Printer.print("Enter incorrect action number!!!");


                }

            }

        } catch (ImpossibleAmountOfSweets ex) {
            Printer.print("Input incorrect amount of sweets!!" +
                    "\nCorrect range " + SweetsCreator.MIN_AMOUNT + "..." + SweetsCreator.MAX_AMOUNT);
        } catch (InputMismatchException exception) {
            Printer.print("Input incorrect data!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
