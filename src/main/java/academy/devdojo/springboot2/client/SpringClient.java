package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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


        Anime kingdom = Anime.builder().name("kingdom").build();
        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/anime/", kingdom, Anime.class);

        log.info("kingdom saved {}", kingdomSaved);



    }
}
