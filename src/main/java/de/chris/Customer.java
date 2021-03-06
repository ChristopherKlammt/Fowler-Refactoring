package de.chris;

import java.util.*;

class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

    Customer(String newname) {
        name = newname;
    }

    void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    String getName() {
        return name;
    }

    public String htmlStatement() {
        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("<h1>Rentals for <em>" + getName() + "</em></h1><p>\n");

        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();

            result.append(rental.getMovie().getTitle()).append(": ").append(String.valueOf(rental.getCharge())).append("<br>\n");
        }
        //add footer lines
        result.append("</p><p>You owe <em>").append(String.valueOf(getTotalCharge())).append("</em></p>\n");
        result.append("<p>On this rental you earned <em>").append(String.valueOf(getTotalFrequentRenterPoints())).append("</em> frequent renter points</p>");
        return result.toString();
    }

    String statement() {
        Enumeration enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();

            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(String.valueOf(each.getCharge())).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(getTotalCharge())).append("\n");
        result.append("You earned ").append(String.valueOf(getTotalFrequentRenterPoints())).append(" frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();

        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            result += rental.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();

        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            result += rental.getFrequentRenterPoints();
        }

        return result;
    }

}