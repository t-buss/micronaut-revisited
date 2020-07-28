package de.tbuss.recipesspring;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ShoppingListItem {
    @Id
    @GeneratedValue
    private UUID id;
    @Embedded
    private Ingredient item;
    private boolean checked;

    public ShoppingListItem() {
    }

    public ShoppingListItem(UUID id, Ingredient item, boolean checked) {
        this.id = id;
        this.item = item;
        this.checked = checked;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Ingredient getItem() {
        return item;
    }

    public void setItem(Ingredient item) {
        this.item = item;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
