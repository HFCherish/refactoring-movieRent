import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static Widgets.SynataxExample.MOVIE_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RentOrderTest {
    private final GregorianCalendar rentDate = new GregorianCalendar();
    private RentOrder rentOrder;
    private Map<Movie, RentTime> movieRentTimeMap;

    @Before
    public void setUp() {
        movieRentTimeMap = new HashMap<>();
    }

    @Test
    public void shouldCalculateRightTotalPriceWhenRentOneRegularMovie() {
        //given
        Movie movie = new Movie(MOVIE_NAME, MovieType.REGULAR);
        movieRentTimeMap.put(movie, new RentTime(rentDate, 3));
        rentOrder = new RentOrder(movieRentTimeMap);

        //then
        assertThat(rentOrder.getTotalPrice(), is(3.5));
    }

    @Test
    public void shouldCalculateRightTotalPriceWhenRentOneChildrensMovie() {
        //given
        Movie movie = new Movie(MOVIE_NAME, MovieType.CHILDERNS);
        movieRentTimeMap.put(movie, new RentTime(rentDate, 4));
        rentOrder = new RentOrder(movieRentTimeMap);

        //then
        assertThat(rentOrder.getTotalPrice(), is(3.0));
    }

    @Test
    public void shouldCalculateRightTotalPriceWhenRentOneNewReleaseMovie() {
        //given
        Movie movie = new Movie(MOVIE_NAME, MovieType.NEW_RELEASE);
        movieRentTimeMap.put(movie, new RentTime(rentDate, 2));
        rentOrder = new RentOrder(movieRentTimeMap);

        //then
        assertThat(rentOrder.getTotalPrice(), is(6.0));
    }

    @Test
    public void shouldCalculateRightTotalPriceWhenRentMoreThanOneMovie() {
        setMovieRentTimeMapExample();
        rentOrder = new RentOrder(movieRentTimeMap);

        //then
        assertThat(rentOrder.getTotalPrice(), is(25.0));
    }


    @Test
    public void shouldUpdateFRPs() {
        setMovieRentTimeMapExample();
        rentOrder = new RentOrder(movieRentTimeMap);

        assertThat(rentOrder.getTotalAddedFRP(), is(8));

    }

    private void setMovieRentTimeMapExample() {
        Movie regularMovie = new Movie(MOVIE_NAME, MovieType.REGULAR);
        movieRentTimeMap.put(regularMovie, new RentTime(rentDate, 2));
        Movie regularMovie1 = new Movie(MOVIE_NAME, MovieType.REGULAR);
        movieRentTimeMap.put(regularMovie1, new RentTime(rentDate, 3));
        Movie childrensMovie = new Movie(MOVIE_NAME, MovieType.CHILDERNS);
        movieRentTimeMap.put(childrensMovie, new RentTime(rentDate, 3));
        Movie childrensMovie1 = new Movie(MOVIE_NAME, MovieType.CHILDERNS);
        movieRentTimeMap.put(childrensMovie1, new RentTime(rentDate, 4));
        Movie newReleaseMovie = new Movie(MOVIE_NAME, MovieType.NEW_RELEASE);
        movieRentTimeMap.put(newReleaseMovie, new RentTime(rentDate, 2));
        Movie newReleaseMovie1 = new Movie(MOVIE_NAME, MovieType.NEW_RELEASE);
        movieRentTimeMap.put(newReleaseMovie1, new RentTime(rentDate, 3));
    }
}
