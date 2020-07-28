package de.tbuss.recipesspring;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe createRecipe(Recipe recipe) {
        return this.recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return this.recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipe(UUID uuid) {
        return this.recipeRepository.findById(uuid);
    }
}
