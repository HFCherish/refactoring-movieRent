import java.util.HashMap;
import java.util.Map;

public class RentOrder {
    private Map<Movie, RentTime> movieRentTimeMap;
    private Customer customer;

    public RentOrder(Map<Movie, RentTime> movieRentTimeMap) {
        this.movieRentTimeMap = movieRentTimeMap;
    }

    public RentOrder(Map<Movie, RentTime> movieRentTimeMap, Customer customer) {
        this.movieRentTimeMap = movieRentTimeMap;
        this.customer = customer;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;

        for(HashMap.Entry<Movie, RentTime> eachMovieRent: movieRentTimeMap.entrySet()) {
            totalPrice += eachMovieRent.getKey().getPriceForRentDays(eachMovieRent.getValue().getDurationDays());
        }

        return totalPrice;
    }

    public int getTotalAddedFRP() {
        int totalAddedFRP = 0;

        for( Movie movie: movieRentTimeMap.keySet() ){
            totalAddedFRP += movie.getAddedFRPsForEachRent();
        }

        return totalAddedFRP;
    }

    public Map<Movie, RentTime> getMovieRentTimeMap() {
        return movieRentTimeMap;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
