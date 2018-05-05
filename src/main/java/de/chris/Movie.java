package de.chris;

class Movie {
    static final int CHILDREN = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;
    private final String title;
    private int priceCode;

    Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }

    int getPriceCode() {
        return priceCode;
    }

    void setPriceCode(int arg) {
        priceCode = arg;
    }

    String getTitle() {
        return title;
    }
    
    double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
            default:
                break;
        }
        return result;
    }
}