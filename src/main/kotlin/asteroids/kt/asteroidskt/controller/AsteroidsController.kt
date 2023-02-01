package asteroids.kt.asteroidskt.controller

import asteroids.kt.asteroidskt.service.AsteroidsService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController("/")
class AsteroidsController(private val asteroidsService: AsteroidsService) {

    @GetMapping("find")
    fun search(@RequestParam start_date:String, @RequestParam end_date:String) : ResponseEntity<*> {
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(asteroidsService.findAsteroids(start_date,end_date))
    }
}