/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Product {
    private String productId;
    private String productName;
    private String productImage;
    private String brief;
    private Date postedDate;
    private int typeId;
    private String account;
    private String unit;
    private int price;
    private int discount;

    public Product() {
    }

    public Product(String productId, String productName, String productImage, String brief, Date postedDate, int typeId, String account, String unit, int price, int discount) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.brief = brief;
        this.postedDate = postedDate;
        this.typeId = typeId;
        this.account = account;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getBrief() {
        return brief;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getAccount() {
        return account;
    }

    public String getUnit() {
        return unit;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", productImage=" + productImage + ", brief=" + brief + ", postedDate=" + postedDate + ", typeId=" + typeId + ", account=" + account + ", unit=" + unit + ", price=" + price + ", discount=" + discount + '}';
    }
    
    
    
}
