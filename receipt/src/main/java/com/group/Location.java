package com.group;

public enum Location {

  CA("California", 9.75),
  NY("New York", 8.875),
  ;

  private String name;
  private double taxRate;

  private Location(String name, double taxRate) {
    this.name = name;
    this.taxRate = taxRate;
  }

  public String getName(){
    return this.name;
  }

  public double getTaxRate() {
    return this.taxRate;
  }

  @Override
  public String toString(){
    return "Location { name: "+this.getName()+" | Tax Rate: $"+ this.taxRate +" }";
  } 


  public static void main(String[] args) {
    Location l = Location.CA;

    System.out.println(l);
  }
}
