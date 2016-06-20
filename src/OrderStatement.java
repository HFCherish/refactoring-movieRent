import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class OrderStatement {
    private RentOrder order;

    public void setOrder(RentOrder order) {
        this.order = order;
    }

    public String getStringStatement() {

        StringBuilder result = new StringBuilder();

        //Order header
        result.append("Rental Record for " + order.getCustomer().getName() + "\n");

        //Order details
        for(HashMap.Entry<Movie, RentTime> movieRentTimeEntry: order.getMovieRentTimeMap().entrySet() ) {
            result.append( "\t" + movieRentTimeEntry.getKey().getMovieName() + "\t" +
                    movieRentTimeEntry.getKey().getPriceForRentDays(movieRentTimeEntry.getValue().getDurationDays()) + "\n");
        }

        //Order footer
        result.append("Amount owed is " + order.getTotalPrice() + "\n" +
                "You earned " + order.getTotalAddedFRP() + " frequent renter points");

        return result.toString();
    }

    public String getHtmlStatement() {

        StringBuilder result = new StringBuilder();

        //Order header
        result.append("<H1>Rental Record for <EM>" + order.getCustomer().getName() + "</EM></H1><P>\n");

        //Order details
        for(HashMap.Entry<Movie, RentTime> movieRentTimeEntry: order.getMovieRentTimeMap().entrySet() ) {
            result.append( movieRentTimeEntry.getKey().getMovieName() +
                    movieRentTimeEntry.getKey().getPriceForRentDays(movieRentTimeEntry.getValue().getDurationDays()) + "<BR>\n");
        }

        //Order footer
        result.append("<P>You owe <EM>" + order.getTotalPrice() + "</EM></P>\n" +
                "On this rental you earned <EM>" + order.getTotalAddedFRP() + "</EM> frequent renter points<P>");

        return result.toString();
    }


    public static void main( String[] args ) {
        OrderStatement statement = new OrderStatement();
        RentTime defaultRentTime = new RentTime(new GregorianCalendar(), 4);
        Map<Movie, RentTime> movieRentTimeMap = new HashMap<>();
        String MOVIE_NAME = "Now you see me";
        movieRentTimeMap.put(new Movie(MOVIE_NAME, MovieType.CHILDERNS), defaultRentTime);
        movieRentTimeMap.put(new Movie(MOVIE_NAME, MovieType.NEW_RELEASE), defaultRentTime);
        statement.setOrder(new RentOrder(movieRentTimeMap, new Customer("Imran")));

        System.out.print(statement.getStringStatement());
        System.out.println();
        System.out.println();
        System.out.print(statement.getHtmlStatement());
    }

}
