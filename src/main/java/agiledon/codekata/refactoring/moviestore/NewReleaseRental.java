package agiledon.codekata.refactoring.moviestore;

class NewReleaseRental  extends Rental {
	
    public NewReleaseRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }
    
    @Override
    public double acount(){
        return daysRented * 3;
    }
}
