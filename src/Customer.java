import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer {

    private List<RentOrder> rentOrders;
    private int frequentRenterPoints;
    private String name;

    public Customer() {
        rentOrders = new ArrayList<>();
        frequentRenterPoints = 0;
        name = "";
    }

    public Customer(String name) {
        this();
        this.name = name;
    }

    public List<RentOrder> getRentOrders() {
        return rentOrders;
    }

    public void rent(Map<Movie, RentTime> moviesToRent) {
        RentOrder aRentOrder = new RentOrder(moviesToRent);
        rentOrders.add(aRentOrder);
        frequentRenterPoints += aRentOrder.getTotalAddedFRP();
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
