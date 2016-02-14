package com.vance.boat.mongodb.service;

import com.vance.boat.mongodb.dao.ProductRepository;
import com.vance.boat.mongodb.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;

  public ProductService() {

  }

  public List<Product> getSku(String sku) {
    return repository.findBySku(sku);
  }

  public List<Product> getAvailableSku(String sku) {
    return repository.findBySkuOnlyAvailables(sku);
  }

  public List<Product> getAvailableSkuCustom(String sku) {
    return repository.findBySkuOnlyAvailablesCustom(sku);
  }

  public void saveProuct() {
    Product product = new Product();
    product.setMaterialName("Vance");
    product.setPrice(123.00);
    product.setSku("Vance Test");

    repository.saveProduct(product);
  }
}
