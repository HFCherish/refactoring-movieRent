import org.junit.Test;

import static Widgets.SynataxExample.MOVIE_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MovieTest {
    private Movie movie;

    @Test
    public void shouldReturnRightPriceGivenRegularMovie() {
        movie = new Movie(MOVIE_NAME, MovieType.REGULAR);

        assertThat(movie.getPriceForRentDays(1), is(2.0));
        assertThat(movie.getPriceForRentDays(2), is(2.0));
        assertThat(movie.getPriceForRentDays(3), is(2.0 + 1*1.5));
        assertThat(movie.getPriceForRentDays(4), is(2.0 + 2*1.5));
    }

    @Test
    public void shouldReturnRightPriceGivenChildrenMovie() {
        movie = new Movie(MOVIE_NAME, MovieType.CHILDERNS);

        assertThat(movie.getPriceForRentDays(1), is(1.5));
        assertThat(movie.getPriceForRentDays(2), is(1.5));
        assertThat(movie.getPriceForRentDays(3), is(1.5));
        assertThat(movie.getPriceForRentDays(4), is(1.5 + 1.5));
        assertThat(movie.getPriceForRentDays(5), is(1.5 + 2*1.5));

    }

    @Test
    public void shouldReturnRightPriceGivenNewReleaseMovie() {
        movie = new Movie(MOVIE_NAME, MovieType.NEW_RELEASE);

        assertThat(movie.getPriceForRentDays(1), is(3.0));
        assertThat(movie.getPriceForRentDays(2), is(6.0));
        assertThat(movie.getPriceForRentDays(3), is(9.0));
        assertThat(movie.getPriceForRentDays(4), is(12.0));

    }

    @Test
    public void shouldReturn1FRPGivenNonNewReleaseMovie() {
        movie = new Movie(MOVIE_NAME, MovieType.CHILDERNS);
        assertThat(movie.getAddedFRPsForEachRent(), is(1));

        movie = new Movie(MOVIE_NAME, MovieType.REGULAR);
        assertThat(movie.getAddedFRPsForEachRent(), is(1));

    }

    @Test
    public void shouldReturn2FRPGienNewReleaseMovie() {
        movie = new Movie(MOVIE_NAME, MovieType.NEW_RELEASE);
        assertThat(movie.getAddedFRPsForEachRent(), is(2));
    }
}
