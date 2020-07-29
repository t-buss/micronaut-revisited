package de.tbuss.recipesmicronaut;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@JdbcRepository
public interface ShoppingListRepository extends CrudRepository<ShoppingListItem, UUID> {
}
