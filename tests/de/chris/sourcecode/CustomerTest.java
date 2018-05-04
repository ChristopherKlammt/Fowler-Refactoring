package de.chris.sourcecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer = new Customer("Felix");
    Movie movieRegular = new Movie("Jurassic Park", Movie.REGULAR);
    Movie movieNew = new Movie("Fluch der Karibik", Movie.NEW_RELEASE);
    Movie movieChildrens = new Movie("Tim und Struppi", Movie.CHILDRENS);
    Rental rentalRegular = new Rental(movieRegular, 10);
    Rental rentalNew = new Rental(movieNew, 5);
    Rental rentalChildrens = new Rental(movieChildrens, 7);

    @Test
    void getName() {
        assertEquals("Felix", customer.getName());
    }

    @Test
    void statement() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rental Record for " + customer.getName() + "\n");
        stringBuilder.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");
        stringBuilder.append("Amount owed is 0.0" + "\n");
        stringBuilder.append("You earned 0 frequent renter points");

        assertEquals(stringBuilder.toString(), customer.statement());
    }

    @Test
    void addRental() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rental Record for " + customer.getName() + "\n");
        stringBuilder.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");
        stringBuilder.append("\t" + "Jurassic Park" + "\t" + "\t" + 10 + "\t" + 14.0 + "\n");
        stringBuilder.append("\t" + "Fluch der Karibik" + "\t" + "\t" + 5 + "\t" + 15.0 + "\n");
        stringBuilder.append("\t" + "Tim und Struppi" + "\t" + "\t" + 7 + "\t" + 7.5 + "\n");
        stringBuilder.append("Amount owed is 36.5" + "\n");
        stringBuilder.append("You earned 4 frequent renter points");

        customer.addRental(rentalRegular);
        customer.addRental(rentalNew);
        customer.addRental(rentalChildrens);

        assertEquals(stringBuilder.toString(), customer.statement());
    }

}