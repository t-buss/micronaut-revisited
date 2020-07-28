package de.tbuss.recipesspring;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository()
public interface RecipeRepository extends CrudRepository<Recipe, UUID> {
    List<Recipe> findAll();

    Recipe save(Recipe recipe);

    Optional<Recipe> findById(UUID id);
}
