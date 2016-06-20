import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static Widgets.SynataxExample.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class OrderStatementTest {

    private OrderStatement statement;

    @Before
    public void setUp() {
        statement = new OrderStatement();
        setDefaultOrder();
    }

    @Test
    public void shouldReturnStatement() {
        String statmentString = statement.getStringStatement();
        assertThat( statmentString, containsString("\t" + MOVIE_NAME +"\t3.0\n") );
        assertThat( statmentString, containsString("\t" + MOVIE_NAME +"\t12.0\n") );
        assertThat( statmentString, containsString("Rental Record for " + CUSTOMER_NAME + "\n"));
        assertThat( statmentString, containsString("Amount owed is 15.0\n" +
                "You earned 3 frequent renter points"));
    }

    private void setDefaultOrder() {
        RentTime defaultRentTime = new RentTime(new GregorianCalendar(), 4);
        Map<Movie, RentTime> movieRentTimeMap = new HashMap<>();
        movieRentTimeMap.put(new Movie(MOVIE_NAME, MovieType.CHILDERNS), defaultRentTime);
        movieRentTimeMap.put(new Movie(MOVIE_NAME, MovieType.NEW_RELEASE), defaultRentTime);
        statement.setOrder(new RentOrder(movieRentTimeMap, new Customer(CUSTOMER_NAME)));
    }
}
