package com.group;

public class Product {
  private String productName;
  private double price;
  private ProductCategory productCategory;

  private Product(String productName, double price,ProductCategory productCategory){
    this.productName = productName;
    this.price = price;
    this.productCategory = productCategory;
  }

  public static Product of(String productName, double price,ProductCategory productCategory){
    return new Product(productName, price, productCategory);
  }

  public String getName(){
    return this.productName;
  }

  public double getPrice(){
    return this.price;
  }

  public ProductCategory getProductCategory(){
    return this.productCategory;
  }

  @Override
  public String toString(){
    return "Product { name: " + this.productName + 
    " | price: " + this.price + " | product Category: " + this.productCategory.name() + "}";
  }

 
}
