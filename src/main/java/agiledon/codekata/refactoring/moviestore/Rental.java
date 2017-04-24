package agiledon.codekata.refactoring.moviestore;

class Rental {
	
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
    
    public String getMovieTitle(){
    	return movie.getTitle();
    }
    
    public double determineAmounts(){
    	double thisAmount = 0;
    	
        //determine amounts for each line
        switch (movie.getPriceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDREN:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        
        return thisAmount;
    }
    
    public boolean isMovieNewRelease(){
    	
    	 if (movie.getPriceCode()  == PriceCode.NEW_RELEASE
                 &&
                 daysRented > 1){
    		 
    		 return true;
    	 }
    	 
    	 return false;
    }
}
