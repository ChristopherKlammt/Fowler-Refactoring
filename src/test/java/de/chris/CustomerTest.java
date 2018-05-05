package de.chris;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private final Customer customer = new Customer("Felix");
    private final Movie movieRegular = new Movie("Jurassic Park", Movie.REGULAR);
    private final Movie movieNew = new Movie("Fluch der Karibik", Movie.NEW_RELEASE);
    private final Movie movieChildren = new Movie("Tim und Struppi", Movie.CHILDREN);
    private final Rental rentalRegular = new Rental(movieRegular, 10);
    private final Rental rentalNew = new Rental(movieNew, 5);
    private final Rental rentalChildren = new Rental(movieChildren, 7);

    @Test
    void getName() {
        assertEquals("Felix", customer.getName());
    }

    @Test
    void statementTest() {
        String string = "Rental Record for " + customer.getName() + "\n" +
                "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n" +
                "Amount owed is 0.0" + "\n" +
                "You earned 0 frequent renter points";

        assertEquals(string, customer.statement());
    }

    @Test
    void htmlStatement() {
        String string = "<h1>Rentals for <em>" + customer.getName() + "</em></h1><p>\n" +
                "</p><p>You owe <em>0.0</em></p>" + "\n" +
                "<p>On this rental you earned <em>0</em> frequent renter points</p>";

        assertEquals(string, customer.htmlStatement());
    }

    @Test
    void addRentalTest() {
        String string = "Rental Record for " + customer.getName() + "\n" +
                "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n" +
                "\t" + "Jurassic Park" + "\t" + "\t" + 10 + "\t" + 14.0 + "\n" +
                "\t" + "Fluch der Karibik" + "\t" + "\t" + 5 + "\t" + 15.0 + "\n" +
                "\t" + "Tim und Struppi" + "\t" + "\t" + 7 + "\t" + 7.5 + "\n" +
                "Amount owed is 36.5" + "\n" +
                "You earned 4 frequent renter points";

        customer.addRental(rentalRegular);
        customer.addRental(rentalNew);
        customer.addRental(rentalChildren);

        assertEquals(string, customer.statement());
    }

}