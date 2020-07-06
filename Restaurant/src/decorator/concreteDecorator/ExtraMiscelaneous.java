/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decorator.concreteDecorator;

import abstractEntity.Food;
import decorator.decorator_concreteComponent.ExtraIngredients;

/**
 *
 * @author jackl
 */
public class ExtraMiscelaneous extends ExtraIngredients{
     public ExtraMiscelaneous(Food sandwich) {
        super(sandwich);
    }
    @Override
    public void showInfo(String type){
        this.getSandwich().showInfo(type);
        this.showExtra(type);
        
    }
    public void showExtra(String type){
        if(type.equals("BBQ")){
            System.out.println("Added: bacon");
        }
        else if(type.equals("Italian")){
            System.out.println("Added: Pepperoni");
        }
        else if(type.equals("Standard")){
            System.out.println("Added: Chips");
        }
    }
}
