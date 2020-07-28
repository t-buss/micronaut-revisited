package de.tbuss.recipesspring;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final RecipeService recipeService;

    public ShoppingListService(ShoppingListRepository shoppingListRepository, RecipeService recipeService) {
        this.shoppingListRepository = shoppingListRepository;
        this.recipeService = recipeService;
    }

    public List<ShoppingListItem> getShoppingList() {
        return (List<ShoppingListItem>)this.shoppingListRepository.findAll();
    }

    public List<ShoppingListItem> addIngredientsFromRecipe(UUID recipeId) {
        var optionalRecipe = this.recipeService.getRecipe(recipeId);
        if (optionalRecipe.isPresent()) {
            var recipe = optionalRecipe.get();
            var shoppingListItems = recipe.getIngredients().stream()
                    .map(ingredient -> {
                        var item = new ShoppingListItem();
                        item.setId(UUID.randomUUID());
                        item.setItem(ingredient);
                        item.setChecked(false);
                        return item;
                    })
                    .collect(Collectors.toList());

            return (List<ShoppingListItem>)this.shoppingListRepository.saveAll(shoppingListItems);
        }
        return Collections.emptyList();
    }

    public ShoppingListItem updateItem(UUID id, ShoppingListItem updatedItem) {
        Optional<ShoppingListItem> shoppingListItemOptional = this.shoppingListRepository.findById(id);
        if (shoppingListItemOptional.isEmpty()) return null;

        var shoppingListItem = shoppingListItemOptional.get();
        Ingredient ingredient = updatedItem.getItem();
        if (ingredient != null) {
            if (ingredient.getName() != null) shoppingListItem.getItem().setName(ingredient.getName());
            if (ingredient.getAmount() != 0) shoppingListItem.getItem().setAmount(ingredient.getAmount());
            if (ingredient.getUnit() != null) shoppingListItem.getItem().setUnit(ingredient.getUnit());
        }
        if (updatedItem.isChecked()) shoppingListItem.setChecked(true);

        shoppingListRepository.save(shoppingListItem);
        return shoppingListItem;
    }

    public void deleteItem(UUID uuid) {
        this.shoppingListRepository.deleteById(uuid);
    }
}
