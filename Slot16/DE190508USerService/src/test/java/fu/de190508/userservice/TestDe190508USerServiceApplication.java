package fu.de190508.userservice;

import org.springframework.boot.SpringApplication;

public class TestDe190508USerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(De190508USerServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
