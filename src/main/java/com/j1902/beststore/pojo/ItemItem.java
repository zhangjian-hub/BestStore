package com.j1902.beststore.pojo;

public class ItemItem {
    private Integer id;

    private Integer itemPropertyId;

    private Integer sizeId;

    private Integer colorId;

    private Integer inventory;

    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemPropertyId() {
        return itemPropertyId;
    }

    public void setItemPropertyId(Integer itemPropertyId) {
        this.itemPropertyId = itemPropertyId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
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
}