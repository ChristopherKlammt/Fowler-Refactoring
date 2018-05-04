package de.chris.sourcecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
    private final Movie movie = new Movie("Jurassic Park", Movie.REGULAR);
    private final Rental rental = new Rental(movie, 10);

    @Test
    void testGetDaysRented() {
        assertEquals(rental.getDaysRented(), 10);
    }

    @Test
    void testGetMovie() {
        assertEquals(rental.getMovie(), movie);
    }

}