package de.tbuss.recipesspring;

import javax.persistence.Embeddable;

@Embeddable
public class Ingredient {
    private String name;
    private Unit unit;
    private int amount;

    public Ingredient() {
    }

    public Ingredient(String name, Unit unit, int amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public enum Unit {
        GRAM, MILLILITERS, PIECES
    }
}
