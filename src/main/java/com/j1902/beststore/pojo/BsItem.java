package com.j1902.beststore.pojo;

public class BsItem {
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
        this.name = name == null ? null : name.trim();
    }

    public String getSuitablePeople() {
        return suitablePeople;
    }

    public void setSuitablePeople(String suitablePeople) {
        this.suitablePeople = suitablePeople == null ? null : suitablePeople.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
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
        this.image = image == null ? null : image.trim();
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
        this.description = description == null ? null : description.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    @Override
    public String toString() {
        return "BsItem{" +
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
                '}';
    }
}