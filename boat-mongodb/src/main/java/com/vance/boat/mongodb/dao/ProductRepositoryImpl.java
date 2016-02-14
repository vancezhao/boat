package com.vance.boat.mongodb.dao;

import java.util.List;
import com.vance.boat.mongodb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
  @Autowired
  private MongoTemplate mongoTemplate;

  public List<Product> findBySkuOnlyAvailablesCustom(String sku) {
    Criteria criteria =
        Criteria.where("sku").is(sku).andOperator(Criteria.where("availability").is(1));
    return mongoTemplate.find(Query.query(criteria), Product.class);
  }

  @Override public void saveProduct(Product product) {
    mongoTemplate.save(product);
  }
}
