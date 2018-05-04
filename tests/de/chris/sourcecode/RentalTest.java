package de.chris.sourcecode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
    private Movie movie = new Movie("Jurassic Park", Movie.REGULAR);
    private Rental rental = new Rental(movie, 10);

    @Test
    void getDaysRented() {
        assertEquals(rental.getDaysRented(), 10);
    }

    @Test
    void getMovie() {
        assertEquals(rental.getMovie(), movie);
    }

}