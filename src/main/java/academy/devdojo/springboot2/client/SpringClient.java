package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/anime/{id}",
                Anime.class,3);

        log.info(entity);

        Anime[] object = new RestTemplate().getForObject("http://localhost:8080/anime/all",
                Anime[].class);

        log.info(Arrays.toString(object));


        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/anime/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                }
        );

        log.info(exchange.getBody());


        Anime samurai = Anime.builder().name("samurai5").build();
        ResponseEntity<Anime> samuraiSaved = new RestTemplate().exchange("http://localhost:8080/anime/",
                HttpMethod.POST,
                new HttpEntity<>(samurai),
                Anime.class);

        Anime animeToBeUpdated = samuraiSaved.getBody();
        animeToBeUpdated.setName("samurai xpto3");
        new RestTemplate().exchange("http://localhost:8080/anime/",
                HttpMethod.PUT,
                new HttpEntity<>(animeToBeUpdated,createJsonHeader()),
                Void.class);


        Anime animeToBeDeleted = samuraiSaved.getBody();
        new RestTemplate().exchange("http://localhost:8080/anime/{id}",
                HttpMethod.DELETE,
               null,
                Void.class,
                animeToBeDeleted.getId());

        log.info("samurai animeToBeDeleted {}",animeToBeDeleted);

    }

    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
