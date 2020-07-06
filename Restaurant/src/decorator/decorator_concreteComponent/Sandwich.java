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
public class Sandwich extends Food{

    public Sandwich() {
    }
    
    
    

    @Override
    public void showInfo() {
        this.showInfo(" ");
    }

    @Override
    public void showInfo(String type) {
        if(type==" "){
            System.out.println("Making standard sandwich");
        }else{
            System.out.println("Making "+ type +" sandwich");
        }
    }
    
}
