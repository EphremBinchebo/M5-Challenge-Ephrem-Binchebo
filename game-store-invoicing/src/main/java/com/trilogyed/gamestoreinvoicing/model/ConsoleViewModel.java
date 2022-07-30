package com.trilogyed.gamestoreinvoicing.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {
    private long id;
    private String model;
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    private java.math.BigDecimal price;
    private long quantity;

    public ConsoleViewModel() {
    }

    public ConsoleViewModel(long id, String model, String manufacturer, String memoryAmount, String processor, BigDecimal price, long quantity) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.memoryAmount = memoryAmount;
        this.processor = processor;
        this.price = price;
        this.quantity = quantity;
    }

    public ConsoleViewModel(long id, BigDecimal price, long quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        if (!(o instanceof ConsoleViewModel)) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return id == that.id && quantity == that.quantity && Objects.equals(model, that.model) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(memoryAmount, that.memoryAmount) && Objects.equals(processor, that.processor) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memoryAmount, processor, price, quantity);
    }

    @Override
    public String toString() {
        return "ConsoleViewModel{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memoryAmount='" + memoryAmount + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
