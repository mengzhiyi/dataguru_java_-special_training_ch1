package agiledon.codekata.refactoring.moviestore;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    public static final String REGULAR_MOVIE_NAME = "Brave Heart";
    public static final String NEW_RELEASE_MOVIE_NAME = "Iron Man";
    public static final String CUSOMTER_NAME = "zhangyi";
    public static final String CHILDREN_MOVIE = "Kongfu Panda";
    private Movie regularMovie;
    private Customer customer;
    private Movie newRleaseMovie;
    private Movie childrenMovie;

    @Before
    public void setUp() throws Exception {
        regularMovie = new RegularMovie(REGULAR_MOVIE_NAME);
        customer = new Customer(CUSOMTER_NAME);
        newRleaseMovie = new NewReleaseMovie(NEW_RELEASE_MOVIE_NAME);
        childrenMovie = new ChildrenMovie(CHILDREN_MOVIE);
    }

    @Test
    public void should_statement_for_regular_movie_and_rental_days_less_than_or_equal_to_2() {
        Rental rental = new RegularRental(regularMovie, 2);
        Customer customer = new Customer(CUSOMTER_NAME);
        customer.addRental(rental);

        double expectedTotalAmount = 2.0;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, REGULAR_MOVIE_NAME, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_regular_movie_and_rental_days_greater_than_2() {
        Rental rental = new RegularRental(regularMovie, 3);
        customer.addRental(rental);

        double expectedTotalAmount = 3.5;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, REGULAR_MOVIE_NAME, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_new_release_movie_and_rental_days_less_than_or_equal_to_1() {
        Rental rental = new NewReleaseRental(newRleaseMovie, 1);
        customer.addRental(rental);

        double expectedTotalAmount = 3.0;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, NEW_RELEASE_MOVIE_NAME, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_new_release_movie_and_rental_days_greater_than_1() {
        Rental rental = new NewReleaseRental(newRleaseMovie, 3);
        customer.addRental(rental);

        double expectedTotalAmount = 9.0;
        int expectedFrequentRenterPoints = 2;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, NEW_RELEASE_MOVIE_NAME, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_children_movie_and_rental_days_less_than_or_equal_to_3() {
        Rental rental = new ChildrenRental(childrenMovie, 3);
        customer.addRental(rental);

        double expectedTotalAmount = 1.5;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, CHILDREN_MOVIE, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_children_movie_and_rental_days_greater_than_3() {
        Rental rental = new ChildrenRental(childrenMovie, 4);
        customer.addRental(rental);

        double expectedTotalAmount = 3.0;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, CHILDREN_MOVIE, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_all_kinds_of_movie() {
        Rental rentalForRegularMovie = new RegularRental(regularMovie, 3);
        Rental rentalForNewReleaseMovie = new NewReleaseRental(newRleaseMovie, 3);
        Rental rentalForChildrenMovie = new ChildrenRental(childrenMovie, 3);
        customer.addRental(rentalForRegularMovie);
        customer.addRental(rentalForNewReleaseMovie);
        customer.addRental(rentalForChildrenMovie);

        assertThat(customer.statement(), is("Rental Record for zhangyi\n\t" +
                "Brave Heart\t3.5\n" +
                "\tIron Man\t9.0\n" +
                "\tKongfu Panda\t1.5\n" +
                "Amount owed is 14.0\n" +
                "You earned 4 frequent renter points"));

    }

    private String result(String customerName, String movieName, double totalAmout, int frequentRenterPoints) {
        return String.format("Rental Record for %s\n\t" +
                "%s\t%s\nAmount owed is %s\n" +
                "You earned %d frequent renter points", customerName, movieName, totalAmout, totalAmout, frequentRenterPoints);
    }
}