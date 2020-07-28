package de.tbuss.recipesspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipesService) {
        this.recipeService = recipesService;
    }

    @GetMapping("/recipes")
    public List<Recipe> get() {
        return this.recipeService.getAllRecipes();
    }

    @PostMapping("/recipes")
    public Recipe post(@RequestBody Recipe createRecipeCommand) {
        return this.recipeService.createRecipe(createRecipeCommand);
    }
}
