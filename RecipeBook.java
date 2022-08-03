
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeBook {
    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }
    
    public void add(Recipe recipe) {
        this.recipes.add(recipe);
    }
    
    public String toString() {
        String output = "";
        for (Recipe recipe: recipes) {
            output += recipe + "\n";
        }
        return output;
    }
    
    public void readFromFile(String input) {
        try(Scanner scan = new Scanner(Paths.get(input))) {
            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                int time = Integer.valueOf(scan.nextLine());
                ArrayList<String> ingredients = new ArrayList<>();
                while (true) {
                    String ingredient = scan.nextLine();
                    if (ingredient.equals("")) {
                        recipes.add(new Recipe(name, time, ingredients));
                        break;
                    } if (!scan.hasNextLine()) {
                        ingredients.add(ingredient);
                        recipes.add(new Recipe(name, time, ingredients));
                        break;
                    }
                    ingredients.add(ingredient);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public String nameSearch(String nameSearched) {
        String toReturn = "";
        for (Recipe recipe: this.recipes) {
            if (recipe.getName().contains(nameSearched)) {
                toReturn += recipe.toString() + "\n";
            }
        }
        return toReturn;
    }
    
    public String timeSearch(int timeSearched) {
        String toReturn = "";
        for (Recipe recipe: this.recipes) {
            if (recipe.getTime() <= timeSearched) {
                toReturn += recipe.toString() + "\n";
            }
        }
        return toReturn;
    }
    
    public String ingredientSearch(String ingredient) {
        String toReturn = "";
        for (Recipe recipe: this.recipes) {
            if (recipe.hasIngredient(ingredient)) {
                toReturn += recipe.toString() + "\n";
            }
        }
        return toReturn;
    }
} 
