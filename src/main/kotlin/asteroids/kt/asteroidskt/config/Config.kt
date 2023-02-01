package asteroids.kt.asteroidskt.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Config {

    @Bean
    fun getWebClient(): WebClient {
        return WebClient.builder().baseUrl("https://api.nasa.gov/").build();
    }
}