package goods;

import java.io.Serializable;

public class Goods implements Serializable{

    private int id;
    private String goodsName;
    private double goodsPrice;
    private double goodsWeight;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public double getGoodsPrice() {
        return goodsPrice;
    }
    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public double getGoodsWeight() {
        return goodsWeight;
    }
    public void setGoodsWeight(double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }
    public Goods(int id, String goodsName, double goodsPrice,double goodsWeight) {
        super();
        this.id = id;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsWeight = goodsWeight;
    }

    public String toString() {
        return "Goods [id=" + id + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsWeight=" + goodsWeight + "]";
    }
}
