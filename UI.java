import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class UI {
    private RecipeBook recipes;

    public UI() {
        this.recipes = new RecipeBook();
    }
    
    public void start(Scanner scanner) {
        System.out.print("Files to read: ");
        String input = scanner.nextLine();
        System.out.println("");
        recipes.readFromFile(input);
        
        System.out.println("Commands: \n"
                + "list - lists the recipes\n"
                + "stop - stops the program\n"
                + "find name - searches recipes by name\n"
                + "find cooking time - searches recipes by cooking time\n"
                + "find ingredient - searches recipes by ingredient\n");
        
        while (true) {
            System.out.print("Enter command: ");
            input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            if (input.equals("list")) {
                System.out.println("");
                System.out.println("Recipes:");
                System.out.println(recipes.toString());
            }
            if (input.equals("find name")) {
                System.out.print("Searched word: ");
                String nameSearched = scanner.nextLine();
                System.out.println("");
                System.out.println("Recipes: ");
                System.out.println(recipes.nameSearch(nameSearched));
                System.out.println("");
            }
            if (input.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int timeSearched = Integer.valueOf(scanner.nextLine());
                System.out.println("");
                System.out.println("Recipes: ");
                System.out.println(recipes.timeSearch(timeSearched));
                System.out.println("");
            }
            if (input.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String ingredient = scanner.nextLine();
                System.out.println("");
                System.out.println("Recipes: ");
                System.out.println(recipes.ingredientSearch(ingredient));
                System.out.println("");
            }
        }
    }
}
