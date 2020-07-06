/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decorator.decorator_concreteComponent;

import abstractEntity.Food;

/**
 *
 * @author jackl
 */
public abstract class ExtraIngredients extends Food{
    
    protected Food sandwich;
    
    public ExtraIngredients(Food sandwich) {
        this.sandwich = sandwich;
    }

    public Food getSandwich() {
        return sandwich;
    }

    public void setSandwich(Food sandwich) {
        this.sandwich = sandwich;
    }
    
    

    @Override
    public void showInfo() {
        this.getSandwich().showInfo(" ");
    }


    @Override
    public void showInfo(String type) {
        this.getSandwich().showInfo(type);
    }
    
}
