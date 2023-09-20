package com.group;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Receipt {
  private Map<Product, Integer> products;
  private double subtotal;
  private double tax;
  private double total;

  public Receipt() {
    products = new HashMap<>();
    this.subtotal = 0;
    this.tax = 0;
    this.total = 0;
  }

  public double getSubtotal(){
    return this.subtotal;
  }
  
  public double getTax(){
    return this.tax;
  }

  public double getTotal(){
    return this.total;
  }

  public Map<Product, Integer> getProducts() {
    return this.products;
  }

  public void checkout(Location location) {
    this.tax = Calculator.calculateTax(this.products, location);
    this.subtotal = Calculator.calculateSubtotal(this.products, location);
    this.total = Calculator.calculateTotal(this.products, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Product product : this.products.keySet()) {
      sb.append(product + "\n");
    }
    sb.append("\n");
    sb.append("subtotal: $" + this.subtotal + "\n")
        .append("tax: $" + this.tax + "\n")
        .append("total: $" + this.total);
    return sb.toString();
  }
}
