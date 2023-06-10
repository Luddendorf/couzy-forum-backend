package com.breeze;

public interface Eatable {

  String makeDescription(Integer fruitId);

  Double calculatePrice(Double price, Double discount);
}
