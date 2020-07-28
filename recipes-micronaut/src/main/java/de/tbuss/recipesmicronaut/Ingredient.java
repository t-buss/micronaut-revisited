package de.tbuss.recipesmicronaut;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Embeddable
public class Ingredient {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Unit unit;
    private int amount;

    public Ingredient() {}

    public Ingredient(UUID id,String name, Unit unit, int amount) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit() {
        return unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public enum Unit {
        GRAM, MILLILITERS, PIECES
    }
}
