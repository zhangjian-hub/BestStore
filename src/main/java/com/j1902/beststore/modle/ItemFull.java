package com.j1902.beststore.modle;

public class ItemFull {

    private Integer id;

    private String name;

    private String suitablePeople;

    private String type;

    private String size;

    private String color;

    private Float price;

    private Integer inventory;

    private String image;

    private Integer salesVolume;

    private String description;

    private String supplier;
    //数量
    private Integer number;

    private Integer shoopingCartId;

    public ItemFull() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuitablePeople() {
        return suitablePeople;
    }

    public void setSuitablePeople(String suitablePeople) {
        this.suitablePeople = suitablePeople;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getShoopingCartId() {
        return shoopingCartId;
    }

    public void setShoopingCartId(Integer shoopingCartId) {
        this.shoopingCartId = shoopingCartId;
    }

    @Override
    public String toString() {
        return "ItemFull{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", suitablePeople='" + suitablePeople + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", image='" + image + '\'' +
                ", salesVolume=" + salesVolume +
                ", description='" + description + '\'' +
                ", supplier='" + supplier + '\'' +
                ", number=" + number +
                ", shoopingCartId=" + shoopingCartId +
                '}';
    }
}
