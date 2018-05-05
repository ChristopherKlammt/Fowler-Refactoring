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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            double thisAmount;
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = amountFor(each);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(String.valueOf(thisAmount)).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
        return result.toString();
    }

    private double amountFor(Rental rental) {
        double result = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (rental.getDaysRented() > 2)
                    result += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (rental.getDaysRented() > 3)
                    result += (rental.getDaysRented() - 3) * 1.5;
                break;
            default:
                break;
        }
        return result;
    }

}

