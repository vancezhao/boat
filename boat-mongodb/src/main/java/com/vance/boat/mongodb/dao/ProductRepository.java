package com.vance.boat.mongodb.dao;

import com.vance.boat.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


// Table 5.1. Supported keywords for query methods
// http://docs.spring.io/spring-data/data-mongodb/docs/current/reference/html/mongo.repositories.html
public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {
    public List<Product> findBySku(String sku);

    @Query(value = "{sku: ?0, availability : 1}")
    public List<Product> findBySkuOnlyAvailables(String sku);


}
