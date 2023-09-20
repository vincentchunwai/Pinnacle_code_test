package com.group;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Product book = Product.of("book", 17.99, ProductCategory.OTHER);
        Product food = Product.of("potato chips", 3.99, ProductCategory.FOOD);
        Product jacket = Product.of("jacket", 23, ProductCategory.CLOTHING);

        

        Receipt r1 = new Receipt();
        r1.getProducts().put(book, 1);
        r1.getProducts().put(food, 1);
        //r1.getProducts().put(jacket, 1);
        r1.checkout(Location.CA);

       System.out.println(r1);
       
    }
}
