package asteroids.kt.asteroidskt.service.impl

import asteroids.kt.asteroidskt.service.AsteroidsService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder


@Service
class AsteroidsServiceImpl(private val webClient: WebClient, @Value("\${asteroids.api-key}") private val apiKey: String) : AsteroidsService {

    override fun findAsteroids(startDate: String, endDate: String): String? {
        return webClient.get()
            .uri { uri: UriBuilder ->
                uri.path("neo/rest/v1/feed")
                    .queryParams(getHeaders(startDate, endDate))
                    .build()
            }
            .exchange()
            .block()
            ?.bodyToMono(String::class.java)
            ?.block()
    }

    private fun getHeaders(startDate: String, endDate: String): MultiValueMap<String, String> {
        val map: MultiValueMap<String, String> = LinkedMultiValueMap()
        map.add("start_date", startDate)
        map.add("end_date", endDate)
        map.add("api_key", apiKey)
        return map
    }
}