
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
class Recipe {
    private String name;
    private int time;
    private ArrayList<String> ingredients;

    public Recipe(String name, int time, ArrayList<String> ingredients) {
        this.name = name;
        this.time = time;
        this.ingredients = ingredients;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getTime() {
        return this.time;
    }
    
    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }
    
    public Boolean hasIngredient(String ingredientToFind) {
        for (String ingredient: this.ingredients) {
            if (ingredient.equals(ingredientToFind)) {
                return true;
            }
        }
        return false;
    }
    
    public String toString() {
        return this.name + ", cooking time: " + this.time;
    }
} 
