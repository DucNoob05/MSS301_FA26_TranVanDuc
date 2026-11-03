package fu.de190508.reservation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Cung cap ObjectMapper de deserialize Object data tu Feign sang RoomDTO.
 */
@Configuration
public class HttpClientConfig {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
