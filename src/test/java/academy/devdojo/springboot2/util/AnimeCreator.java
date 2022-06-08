package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved(){
        return Anime.builder().
                name("Chico Tripa")
                .build();
    }

    public static Anime createValidAnime(){
        return Anime.builder().
                name("Chico Tripa")
                .id(1L)
                .build();
    }

    public static Anime createValidUpdatedAnime(){
        return Anime.builder().
                name("Chico Tripa, o retorno")
                .id(1L)
                .build();
    }



}
