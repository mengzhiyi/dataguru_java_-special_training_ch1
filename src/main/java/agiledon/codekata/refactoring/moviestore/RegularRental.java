package agiledon.codekata.refactoring.moviestore;

class RegularRental extends Rental {
	
    public RegularRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }
    
    @Override
    public double acount(){
	    thisAmount += 2;
	    if (daysRented > 2)
	        thisAmount += (daysRented - 2) * 1.5;

	    return thisAmount;
    }
}
