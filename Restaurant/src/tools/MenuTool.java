/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import static Client.Main.in;
import abstractEntity.Food;
import composite.leaf_compound.CompoundPizza;
import composite.leaf_compound.Ingredient;
import decorator.concreteDecorator.ExtraCheese;
import decorator.concreteDecorator.ExtraMiscelaneous;
import decorator.concreteDecorator.Vegetables;
import decorator.decorator_concreteComponent.Sandwich;
import java.util.Scanner;

/**
 *
 * @author jackl
 */
public class MenuTool {

    public static Scanner add = new Scanner(System.in);

    public MenuTool() {
    }

    public static void mainMenu() {
        int option = 0;
        do {
            System.out.println("Press 1 if you want to order a sandwich (uses decorator pattern)");
            System.out.println("Press 2 if you want to order a pizza (uses composite pattern)");
            System.out.println("Press 0 to exit");
            option = in.nextInt();
            if (option == 1) {
                outSandwich(sandwichTypeSelection());
            }else if(option==2) {
                outPizza(pizzaPartitionsSelection());
            }
        } while (option != 0);
    }

    public static int pizzaPartitionsSelection() {
        int option = 0;
        System.out.println("=====================================");
        do {
            System.out.println("Enter the required option:");
            System.out.println("How many partitions do you would like in your pizza? Maximum 4");
            option = in.nextInt();
            if (option > 4) {
                System.out.println("Invalid input");
            }
        } while (option > 4 || option <= 0);
        return option;
    }

    public static void outPizza(int option) {
        int select = 0;
        int selectB = 0;

        CompoundPizza storage = new CompoundPizza(" of a Compund Pizza");
        for (int i = 0; i < option; i++) {
            CompoundPizza order = new CompoundPizza(String.valueOf((i + 1)));
            System.out.println("Press 1 to add champignon pizza ingredients to partition " + (i + 1));
            System.out.println("Press 2 to add hawaiian pizza ingredients to partition " + (i + 1));
            System.out.println("Press 3 to add napolitan ingredients to partition " + (i + 1));
            System.out.println("Press 4 to add mexican pizza ingredients to partition " + (i + 1));
            select = in.nextInt();
            switch (select) {
                case 1:
                    order.insertNode(new Ingredient("Champignon ingredients"));
                    System.out.println("Preparing...");
                    break;
                case 2:
                    order.insertNode(new Ingredient("Hawaiian ingredients"));
                    System.out.println("Preparing...");
                    break;
                case 3:
                    order.insertNode(new Ingredient("Napolitan ingredients"));
                    System.out.println("Preparing...");
                    break;
                case 4:
                    order.insertNode(new Ingredient("Mexican ingredients"));
                    System.out.println("Preparing...");
                    break;
                default:
                    System.out.println("WTF!!");
            }
            storage.insertNode(order);
        }
        storage.showInfo();
        do {
            System.out.println("Enter the number of the partition you want to remove");
            System.out.println("Press 6 if you don't want to remove a partition");
            selectB = (in.nextInt() - 1);
            if (selectB >= storage.getNodes().size() || selectB<=0) {
                if (selectB != 5 || selectB<=0) {
                    System.out.println("Invalid input");
                }
            } else {
                Food delete = storage.getNodes().get(selectB);
                storage.removeNode(delete);
                storage.showInfo();
            }
        } while (selectB != 5 || selectB<=0);
        System.out.println("Thank you come again!");
        storage.getNodes().clear();
       
        System.out.println("=====================================");
    }

    public static int sandwichTypeSelection() {
        int option = 0;
        System.out.println("=====================================");
        do {
            System.out.println("Enter the required option:");
            System.out.println("Press 1 to order a BBQ Sandwich");
            System.out.println("Press 2 to order an Italian Sandwich");
            System.out.println("Press 3 to order a standard Sandwich");
            option = in.nextInt();
            if (option > 3 || option <= 0) {
                System.out.println("Invalid input");
            }
        } while (option > 3 || option <= 0);

        return option;
    }

    public static void outSandwich(int option) {

        Food sandwich;
        int extra = 0;
        switch (option) {
            case 1:
                do {
                    System.out.println("The BBQ Sandwich has: Cheddar cheese, grilled ham, bacon, chipoltle sauce and jalapeno peppers");
                    System.out.println("Extra ingredients Addition: ");
                    System.out.println("Press 1 if you would like add extra bacon");
                    System.out.println("Press 2 if you would like add extra cheddar");
                    System.out.println("Press 3 if you would like add extra jalapeno peppers");
                    System.out.println("Press 4 if you would like add extra bacon and extra cheddar");
                    System.out.println("Press 5 if you would like add extra bacon and extra jalapeno peppers");
                    System.out.println("Press 6 if you would like add extra cheddar and extra jalapeno peppers");
                    System.out.println("Press 7 if you would like add all extra ingredients");
                    extra = add.nextInt();
                    if(extra > 7 || extra <= 0){
                        System.out.println("Invalid input");
                    }
                } while (extra > 7 || extra <= 0);

                switch (extra) {
                    case 1:
                        sandwich = new ExtraMiscelaneous(new Sandwich());
                        sandwich.showInfo("BBQ");
                        break;
                    case 2:
                        sandwich = new ExtraCheese(new Sandwich());
                        sandwich.showInfo("BBQ");
                        break;

                    case 3:
                        sandwich = new Vegetables(new Sandwich());
                        sandwich.showInfo("BBQ");
                        break;

                    case 4:
                        sandwich = new ExtraMiscelaneous(new ExtraCheese(new Sandwich()));
                        sandwich.showInfo("BBQ");
                        break;
                    case 5:
                        sandwich = new ExtraMiscelaneous(new Vegetables(new Sandwich()));
                        sandwich.showInfo("BBQ");
                        break;

                    case 6:
                        sandwich = new ExtraCheese(new Vegetables(new Sandwich()));
                        sandwich.showInfo("BBQ");
                        break;
                    case 7:
                        sandwich = new ExtraMiscelaneous(new ExtraCheese(new Vegetables(new Sandwich())));
                        sandwich.showInfo("BBQ");
                        break;
                }
                break;
            case 2:
                do {
                    System.out.println("The Italian Sandwich has: Provolone cheese, presciotto ham, pepperoni, alfredo sauce and red onion, spinach ");
                    System.out.println("Extra ingredients Addition: ");
                    System.out.println("Press 1 if you would like add extra pepperoni");
                    System.out.println("Press 2 if you would like add extra provolone cheese");
                    System.out.println("Press 3 if you would like add extra red onion, spinach");
                    System.out.println("Press 4 if you would like add extra pepperoni and extra provolone cheese");
                    System.out.println("Press 5 if you would like add extra pepperoni and extra red onion, spinach");
                    System.out.println("Press 6 if you would like add extra provolone cheese and extra red onion, spinach");
                    System.out.println("Press 7 if you would like add all extra ingredients");
                    extra = add.nextInt();
                    if(extra > 7 || extra <= 0){
                        System.out.println("Invalid input");
                    }
                } while (extra > 7 || extra <= 0);

                switch (extra) {
                    case 1:
                        sandwich = new ExtraMiscelaneous(new Sandwich());
                        sandwich.showInfo("Italian");
                        break;
                    case 2:
                        sandwich = new ExtraCheese(new Sandwich());
                        sandwich.showInfo("Italian");
                        break;

                    case 3:
                        sandwich = new Vegetables(new Sandwich());
                        sandwich.showInfo("Italian");
                        break;

                    case 4:
                        sandwich = new ExtraMiscelaneous(new ExtraCheese(new Sandwich()));
                        sandwich.showInfo("Italian");
                        break;
                    case 5:
                        sandwich = new ExtraMiscelaneous(new Vegetables(new Sandwich()));
                        sandwich.showInfo("Italian");
                        break;

                    case 6:
                        sandwich = new ExtraCheese(new Vegetables(new Sandwich()));
                        sandwich.showInfo("Italian");
                        break;
                    case 7:
                        sandwich = new ExtraMiscelaneous(new ExtraCheese(new Vegetables(new Sandwich())));
                        sandwich.showInfo("Italian");
                        break;
                }
                break;
            case 3:
                do {
                    System.out.println("The standard Sandwich has: Mozzarella cheese, standard ham, chips, mustard and mayonnaise and lettuce ");
                    System.out.println("Extra ingredients Addition: ");
                    System.out.println("Press 1 if you would like add extra chips");
                    System.out.println("Press 2 if you would like add extra mozzarella cheese");
                    System.out.println("Press 3 if you would like add extra lettuce");
                    System.out.println("Press 4 if you would like add extra chips and extra mozzarella cheese");
                    System.out.println("Press 5 if you would like add extra chips and extra lettuce");
                    System.out.println("Press 6 if you would like add extra mozzarella cheese and extra lettuce");
                    System.out.println("Press 7 if you would like add all extra ingredients");
                    extra = add.nextInt();
                    if(extra > 7 || extra <= 0){
                        System.out.println("Invalid input");
                    }
                } while (extra > 7 || extra <= 0);

                switch (extra) {
                    case 1:
                        sandwich = new ExtraMiscelaneous(new Sandwich());
                        sandwich.showInfo("Standard");
                        break;
                    case 2:
                        sandwich = new ExtraCheese(new Sandwich());
                        sandwich.showInfo("Standard");
                        break;

                    case 3:
                        sandwich = new Vegetables(new Sandwich());
                        sandwich.showInfo("Standard");
                        break;

                    case 4:
                        sandwich = new ExtraMiscelaneous(new ExtraCheese(new Sandwich()));
                        sandwich.showInfo("Standard");
                        break;
                    case 5:
                        sandwich = new ExtraMiscelaneous(new Vegetables(new Sandwich()));
                        sandwich.showInfo("Standard");
                        break;

                    case 6:
                        sandwich = new ExtraCheese(new Vegetables(new Sandwich()));
                        sandwich.showInfo("Standard");
                        break;
                    case 7:
                        sandwich = new ExtraMiscelaneous(new ExtraCheese(new Vegetables(new Sandwich())));
                        sandwich.showInfo("Standard");
                        break;
                }
                break;
        }
        System.out.println("Thank you come again!");
        System.out.println("=====================================");
    }
}
