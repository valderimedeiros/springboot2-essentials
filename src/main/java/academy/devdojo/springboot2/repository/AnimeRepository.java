package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
