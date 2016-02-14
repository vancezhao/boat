package com.vance.boat.mongodb.dao;

import java.util.List;
import com.vance.boat.mongodb.model.Product;


public interface ProductRepositoryCustom {
  public List<Product> findBySkuOnlyAvailablesCustom(String sku);

  public void saveProduct(Product product);
}
