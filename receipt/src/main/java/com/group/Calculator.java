package com.group;

import java.math.BigDecimal;
import java.util.Map;

public class Calculator {

  public static double calculateTotal(Map<Product, Integer> carts, Location location) {
    BigDecimal total = BigDecimal.ZERO;
    double subtotal = calculateSubtotal(carts, location);
    double tax = calculateTax(carts, location);

    total = total.add(BigDecimal.valueOf(subtotal)).add(BigDecimal.valueOf(tax));

    return total.doubleValue();
  }

  public static double calculateSubtotal(Map<Product, Integer> carts, Location location) {
    BigDecimal total = new BigDecimal(0);
    for (Map.Entry<Product, Integer> cart : carts.entrySet()) {
      BigDecimal itemPrice = BigDecimal.valueOf(cart.getKey().getPrice()).multiply(BigDecimal.valueOf(cart.getValue()));
      total = total.add(itemPrice);
    }

    return total.doubleValue();
  }

  public static double calculateTax(Map<Product, Integer> carts, Location location) {

    BigDecimal totalTax = BigDecimal.ZERO;

    for (Map.Entry<Product, Integer> cart : carts.entrySet()) {
      switch (location.getName()) {
        case "California":
          if (cart.getKey().getProductCategory() == ProductCategory.CLOTHING
              || cart.getKey().getProductCategory() == ProductCategory.OTHER) {
            BigDecimal productTax = BigDecimal.valueOf(cart.getKey().getPrice())
                .multiply(BigDecimal.valueOf(Location.CA.getTaxRate() / 100))
                .multiply(BigDecimal.valueOf(cart.getValue()));
            totalTax = totalTax.add(productTax);
          }
          break;
        case "New York":
          if (cart.getKey().getProductCategory() == ProductCategory.OTHER) {
            BigDecimal productTax = BigDecimal.valueOf(cart.getKey().getPrice())
                .multiply(BigDecimal.valueOf(Location.NY.getTaxRate() / 100))
                .multiply(BigDecimal.valueOf(cart.getValue()));
            totalTax = totalTax.add(productTax);
          }
          break;
      }
    }

    return roundTax(totalTax.doubleValue());
  }

  public static double roundTax(double tax) {
    return Math.ceil(tax * 20) / 20.0;
  }
}
