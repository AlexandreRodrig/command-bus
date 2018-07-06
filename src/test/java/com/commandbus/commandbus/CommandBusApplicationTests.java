package com.commandbus.commandbus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.composite.CompositeDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandBusApplicationTests {

	@Autowired
	DiscoveryClient discoveryClient;

	@Test
	public void contextLoads() {
	}

	@Test
	public void discoveryClientIsEureka(){

		assertTrue("discoveryClient is wrong type " + discoveryClient.getClass(), discoveryClient instanceof CompositeDiscoveryClient);
		CompositeDiscoveryClient compositeDiscoveryClient = (CompositeDiscoveryClient) discoveryClient;
		assertTrue("composite discovery client should be composed of Eureka and Simple Discovery client's"
				, compositeDiscoveryClient.getDiscoveryClients().size() == 2);

		assertTrue("the composed discovery client should have a EurekaDiscoveryClient with a higher precedence ",
				compositeDiscoveryClient.getDiscoveryClients().get(0) instanceof EurekaDiscoveryClient);
	}





}
