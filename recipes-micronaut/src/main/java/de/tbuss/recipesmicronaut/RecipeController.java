package de.tbuss.recipesmicronaut;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

@Controller("recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipesService) {
        this.recipeService = recipesService;
    }

    @Get
    public List<Recipe> get() {
        return this.recipeService.getAllRecipes();
    }

    @Post
    public Recipe post(@Body Recipe createRecipeCommand) {
        return this.recipeService.createRecipe(createRecipeCommand);
    }
}
