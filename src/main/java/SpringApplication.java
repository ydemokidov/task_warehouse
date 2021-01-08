import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.MySpringConfiguration;
import transfer.Driver;

import java.io.IOException;
import java.net.URISyntaxException;

public class SpringApplication {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfiguration.class);
        Driver driver = (Driver)context.getBean("driver");
        driver.processWarehouse();
    }
}
