package de.chris.sourcecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    private final Movie movie = new Movie("Jurassic Park", Movie.REGULAR);

    @Test
    void testGetPriceCode() {
        assertEquals(movie.getPriceCode(), Movie.REGULAR);
    }

    @Test
    void testGetTitle() {
        assertEquals(movie.getTitle(), "Jurassic Park");
    }

    @Test
    void testSetPriceCode() {
        movie.setPriceCode(Movie.NEW_RELEASE);
        assertEquals(movie.getPriceCode(), Movie.NEW_RELEASE);
    }

}