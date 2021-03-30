public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    // 비디오 종류별 대여로 계산 기능을 빼내어 별도의 함수로 작성
    public double getCharge()  {
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result +=2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() -3) * 1.5;
                }
                break;
        }
        return result;
    }

    // 최신물을 이틀 이상 대여하면 2포인트 지급하고 그 외엔 1포인트 지급하는 코드를
    // 빼내 getFrequentRenterPoints 메서드로 만들고 이 Rental 클래스로 옮겼다.
    public int getFrequentRenterPoints() {
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }

}
