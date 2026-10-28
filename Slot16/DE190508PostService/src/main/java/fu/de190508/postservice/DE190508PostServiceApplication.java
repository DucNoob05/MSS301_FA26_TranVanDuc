package fu.de190508.postservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DE190508PostServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DE190508PostServiceApplication.class, args);
    }

}
