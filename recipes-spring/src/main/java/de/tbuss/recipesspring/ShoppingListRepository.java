package de.tbuss.recipesspring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingListItem, UUID> {
}
