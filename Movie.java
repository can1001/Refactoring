public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    
    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    private void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                break;
        }
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public String getTitle() {
        return _title;
    }

    private Price _price;

    public double getCharge(int daysRented)  {
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result +=2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented -3) * 1.5;
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }

    abstract class Price {
        abstract int getPriceCode();
    }

    class ChildrensPrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.CHILDRENS;
        }
    }

    class NewReleasePrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.NEW_RELEASE;
        }
    }

    class RegularPrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.REGULAR;
        }
    }

}