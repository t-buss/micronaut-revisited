package de.tbuss.recipesspring;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
public class ShoppingListController {

    private ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/shopping-list")
    List<ShoppingListItem> get() {
        return this.shoppingListService.getShoppingList();
    }

    @PostMapping("/shopping-list/addRecipe/{recipeIdAsString}")
    List<ShoppingListItem> addIngredientsFromRecipe(@PathVariable String recipeIdAsString) {
        return this.shoppingListService.addIngredientsFromRecipe(UUID.fromString(recipeIdAsString));
    }

    @PatchMapping("/shopping-list/{shoppingListItemId}")
    ShoppingListItem updateItem(@PathVariable String shoppingListItemId, @RequestBody ShoppingListItem item) {
        var id = UUID.fromString(shoppingListItemId);
        return this.shoppingListService.updateItem(id, item);
    }

    @DeleteMapping("/shopping-list/{shoppingListItemId}")
    void deleteItem(@PathVariable String shoppingListItemId) {
        this.shoppingListService.deleteItem(UUID.fromString(shoppingListItemId));
    }
}
