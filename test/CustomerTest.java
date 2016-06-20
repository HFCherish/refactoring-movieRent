import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static Widgets.SynataxExample.MOVIE_NAME;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void shouldContainNoOrderWhenNoRent() {
        assertThat(customer.getRentOrders().size(), is(0));
    }

    @Test
    public void shouldNotAddRentOrderAndUpdateWithoutRent() {
        assertThat(customer.getRentOrders().size(), is(0));
        assertThat(customer.getFrequentRenterPoints(), is(0));
    }

    @Test
    public void shouldAddNewRentOrderAndUpdateFRPsAfterRent() {
        //given
        Map<Movie, RentTime> moviesToRent = new HashMap<>();
        moviesToRent.put(new Movie(MOVIE_NAME, MovieType.REGULAR), new RentTime(new GregorianCalendar(), 5));
        moviesToRent.put(new Movie(MOVIE_NAME, MovieType.CHILDERNS), new RentTime(new GregorianCalendar(), 4));
        moviesToRent.put(new Movie(MOVIE_NAME, MovieType.NEW_RELEASE), new RentTime(new GregorianCalendar(), 4));

        //when
        customer.rent(moviesToRent);

        //then
        assertThat(customer.getRentOrders().size(), is(1));
        assertThat(customer.getFrequentRenterPoints(), is(4));
    }

}
