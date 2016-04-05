package com.vance.boat.mongodb.test;

import com.vance.boat.api.TorrentService;
import com.vance.boat.mongodb.BootMongoDB;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by vancezhao on 16/2/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootMongoDB.class)
@WebAppConfiguration
@IntegrationTest("server.port:80")
public class BootMongoDBTest {

  @Autowired
  protected TProtocolFactory protocolFactory;

  @Value("${local.server.port}")
  protected int port;

  protected TorrentService.Client client;

  private Log log = LogFactory.getLog(BootMongoDB.class);

  @Before
  public void setUp() throws Exception {
    String url = "http://localhost:" + port + "/calculator/";
    log.info("Url is: " + url);
    TTransport transport = new THttpClient(url);

    TProtocol protocol = protocolFactory.getProtocol(transport);
    client = new TorrentService.Client(protocol);
  }

  @Test
  public void testAdd() throws Exception {
    //assertEquals(5, client.calculate(2, 3, TOperation.ADD));
    log.debug("start to run the testAdd()");
  }
}
