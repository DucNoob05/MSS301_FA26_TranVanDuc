package fu.de190508.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DE190508ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DE190508ReservationServiceApplication.class, args);
    }

}
