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

    String statement() {
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();

            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(String.valueOf(each.getCharge())).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(getTotalCharge())).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
        return result.toString();
    }

    double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();

        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            result += rental.getCharge();
        }

        return result;
    }

}

