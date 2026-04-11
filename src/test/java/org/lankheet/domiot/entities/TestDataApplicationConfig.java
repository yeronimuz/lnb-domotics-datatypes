package org.lankheet.domiot.entities;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@EntityScan(basePackages = "org.lankheet.domiot.entities")      // <- Replace with your actual entity package
public class TestDataApplicationConfig {

}
