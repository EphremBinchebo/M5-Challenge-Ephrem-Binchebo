package com.trilogyed.gamestoreinvoicing.model;

import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {
    private long id;
    private String title;
    private String esrbRating;
    private String description;
    private BigDecimal price;
    private String studio;
    private long quantity;

    public GameViewModel() {
    }

    public GameViewModel(long id, String title, String esrbRating, String description, BigDecimal price, String studio, long quantity) {
        this.id = id;
        this.title = title;
        this.esrbRating = esrbRating;
        this.description = description;
        this.price = price;
        this.studio = studio;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameViewModel)) return false;
        GameViewModel that = (GameViewModel) o;
        return id == that.id && quantity == that.quantity && Objects.equals(title, that.title) && Objects.equals(esrbRating, that.esrbRating) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(studio, that.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, esrbRating, description, price, studio, quantity);
    }

    @Override
    public String toString() {
        return "GameViewModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", esrbRating='" + esrbRating + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
