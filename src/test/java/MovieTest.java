import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    private final Movie movie = new Movie("Jurassic Park", Movie.REGULAR);

    @Test
    void getPriceCodeTest() {
        assertEquals(movie.getPriceCode(), Movie.REGULAR);
    }

    @Test
    void getTitleTest() {
        assertEquals(movie.getTitle(), "Jurassic Park");
    }

    @Test
    void setPriceCodeTest() {
        movie.setPriceCode(Movie.NEW_RELEASE);
        assertEquals(movie.getPriceCode(), Movie.NEW_RELEASE);
    }

}