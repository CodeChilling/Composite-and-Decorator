/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package composite.leaf_compound;

import abstractEntity.Food;

/**
 *
 * @author jackl
 */
public class Ingredient extends Food{

    public Ingredient(String name) {
        this.setName(name);
    }
    
    

    @Override
    public void showInfo() {
        System.out.println("Ingredient: "+this.getName()+" added");
    }

    @Override
    public void showInfo(String name) {
        this.showInfo();
    }
    
}
