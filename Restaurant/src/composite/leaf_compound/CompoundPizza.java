/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package composite.leaf_compound;

import abstractEntity.Food;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jackl
 */
public class CompoundPizza extends Food{
    
    private List<Food> nodes = new ArrayList<Food>();

    public CompoundPizza(String name) {
        this.setName(name);
    }
    
    public void insertNode(Food food){
        nodes.add(food);
    }
    public void removeNode(Food food){
        nodes.remove(food);
    }

    public Food getNodes(int index) {
        return nodes.get(index);
    }

    public List<Food> getNodes() {
        return nodes;
    }
    
    

    
    @Override
    public void showInfo() {
        System.out.println("Partition "+this.getName());
        for(Food food:nodes){
            food.showInfo();
        }
    }

    @Override
    public void showInfo(String name) {
       this.showInfo();
    }
    
}
