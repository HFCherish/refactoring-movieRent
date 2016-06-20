public class Movie {
    private String movieName;
    private MovieType movieType;

    public Movie(String movieName, MovieType movieType) {
        this.movieName = movieName;
        this.movieType = movieType;
    }

    public double getPriceForRentDays(int rentDays) {
        double result = 0.0;
        switch (movieType){
            case REGULAR:
                result += 2.0;
                if( rentDays > 2 )  result += (rentDays-2) * 1.5;
                break;
            case CHILDERNS:
                result += 1.5;
                if( rentDays > 3 )  result += (rentDays-3) * 1.5;
                break;
            case NEW_RELEASE:
                result += rentDays * 3;
                break;
        }
        return result;
    }

    public int getAddedFRPsForEachRent() {
        return (movieType == MovieType.NEW_RELEASE) ? 2 : 1;
    }

    public String getMovieName() {
        return movieName;
    }

    public MovieType getMovieType() {
        return movieType;
    }
}
