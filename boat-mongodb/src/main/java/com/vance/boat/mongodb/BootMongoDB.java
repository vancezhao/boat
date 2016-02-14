package com.vance.boat.mongodb;

import com.vance.boat.api.TorrentService;
import com.vance.boat.mongodb.model.Product;
import com.vance.boat.mongodb.service.ProductService;
import com.vance.boat.mongodb.service.TorrentServiceHandler;
import java.util.List;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class BootMongoDB {

  @Autowired
  private ProductService productService;

  private static final Logger logger = LoggerFactory.getLogger(BootMongoDB.class);

  public void run(String... args) throws Exception {
    productService.saveProuct();

    List<Product> sku = productService.getSku("NEX.6");
    logger.info("result of getSku is {}", sku);
    List<Product> availableSku = productService.getAvailableSku("NEX.6");
    logger.info("result of getAvailableSku is {}", availableSku);
    List<Product> availableSkuCustom = productService.getAvailableSkuCustom("NEX.6");
    logger.info("result of availableSkuCustom is {}", availableSkuCustom);
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(BootMongoDB.class, args);
  }

  @Bean
  public TProtocolFactory tProtocolFactory() {
    //We will use binary protocol, but it's possible to use JSON and few others as well
    return new TBinaryProtocol.Factory();
  }

  @Bean
  public TServlet calculator(TProtocolFactory protocolFactory, TorrentServiceHandler handler) {
    return new TServlet(new TorrentService.Processor<TorrentServiceHandler>(handler),
        protocolFactory);
  }
}
