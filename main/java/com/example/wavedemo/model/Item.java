package com.example.wavedemo.model;

//TODO use Lombok
//@Data
public class Item extends BaseModel{

    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
