package de.tbuss.recipesmicronaut;

import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller("shopping-list")
public class ShoppingListController {

    private ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @Get
    List<ShoppingListItem> get() {
        return this.shoppingListService.getShoppingList();
    }

    @Post("/addRecipe/{recipeIdAsString}")
    List<ShoppingListItem> addIngredientsFromRecipe(@PathVariable String recipeIdAsString) {
        return this.shoppingListService.addIngredientsFromRecipe(UUID.fromString(recipeIdAsString));
    }

    @Patch("{shoppingListItemId}")
    ShoppingListItem updateItem(@PathVariable String shoppingListItemId, @Body ShoppingListItem item) {
        var id = UUID.fromString(shoppingListItemId);
        return this.shoppingListService.updateItem(id, item);
    }

    @Delete("{shoppingListItemId}")
    void deleteItem(@PathVariable String shoppingListItemId) {
        this.shoppingListService.deleteItem(UUID.fromString(shoppingListItemId));
    }
}
