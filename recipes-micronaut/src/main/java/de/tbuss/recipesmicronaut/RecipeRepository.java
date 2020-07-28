package de.tbuss.recipesmicronaut;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface RecipeRepository extends CrudRepository<Recipe, UUID> {
    @Override
    @Join(value = "ingredients", type = Join.Type.LEFT_FETCH)
    @NonNull
    Iterable<Recipe> findAll();

    @Override
    @Join(value = "ingredients", type = Join.Type.LEFT_FETCH)
    Optional<Recipe> findById(@NotNull @NonNull UUID id);
}
