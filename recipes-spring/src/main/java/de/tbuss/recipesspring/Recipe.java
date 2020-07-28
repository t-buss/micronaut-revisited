package de.tbuss.recipesspring;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable
    private List<Ingredient> ingredients;

    public Recipe() {
    }

    public Recipe(UUID id, String name, String description, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
