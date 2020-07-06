/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import abstractEntity.Food;
import decorator.concreteDecorator.ExtraCheese;

import decorator.concreteDecorator.ExtraMiscelaneous;

import decorator.concreteDecorator.Vegetables;
import decorator.decorator_concreteComponent.Sandwich;
import java.util.Scanner;
import tools.MenuTool;

/**
 *
 * @author jackl
 */
public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=====================================");     
        MenuTool.mainMenu();
        System.out.println("=====================================");  
    }
    

}
