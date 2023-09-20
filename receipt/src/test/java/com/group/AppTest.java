package com.group;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.concurrent.Callable;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit test for Receipt
 */
@ExtendWith(MockitoExtension.class)
public class AppTest {

   @Test
   @DisplayName("Receipt's checkout method test")
   public void testCheckOut() {
      Product book = Product.of("book", 17.99, ProductCategory.OTHER);
      Product potato_chips = Product.of("potato_chips", 3.99, ProductCategory.FOOD);
      Product pencil = Product.of("pencil", 2.99, ProductCategory.OTHER);
      Product shirt = Product.of("shirt", 29.99, ProductCategory.CLOTHING);
      Receipt receipt = new Receipt();
      receipt.getProducts().put(book, 1);
      receipt.getProducts().put(potato_chips, 1);
      receipt.checkout(Location.CA);
      assertEquals(21.98, receipt.getSubtotal());
      assertEquals(1.80, receipt.getTax());
      assertEquals(23.78, receipt.getTotal());

      Receipt receipt2 = new Receipt();
      receipt2.getProducts().put(book, 1);
      receipt2.getProducts().put(pencil, 3);
      receipt2.checkout(Location.NY);
      assertEquals(26.96, receipt2.getSubtotal());
      assertEquals(2.40, receipt2.getTax());
      assertEquals(29.36, receipt2.getTotal());

      Receipt receipt3 = new Receipt();
      receipt3.getProducts().put(pencil, 2);
      receipt3.getProducts().put(shirt, 1);
      receipt3.checkout(Location.NY);
      assertEquals(35.97, receipt3.getSubtotal());
      assertEquals(0.55, receipt3.getTax());
      assertEquals(36.52, receipt3.getTotal());
   }

}
