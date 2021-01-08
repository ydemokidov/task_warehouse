package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import warehouse.Warehouse;

import java.io.IOException;
import java.nio.file.Paths;

@Configuration
@ComponentScan("transfer")
public class MySpringConfiguration {
    private final String fileLocation = "src/main/resources/";

    @Bean
    public Warehouse warehouseA() throws IOException {
        return new Warehouse(10521,Paths.get(fileLocation+"/warehouseA.txt"));
    }

    @Bean
    public Warehouse warehouseB() throws IOException {
        return new Warehouse(0,Paths.get(fileLocation+"/warehouseB.txt"));
    }
}
