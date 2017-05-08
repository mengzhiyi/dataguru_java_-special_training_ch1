package agiledon.codekata.refactoring.moviestore;

abstract class Rental {
	
	protected Movie movie;
    protected int daysRented;
    protected double thisAmount = 0;
    
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    
    public abstract double acount();
    
    public String getMovieTitle(){
    	return movie.getTitle();
    }
    
    public boolean isMovieNewRelease(){
    	
    	 if (movie.isNewRelease()
                 &&
                 daysRented > 1){
    		 
    		 return true;
    	 }
    	 
    	 return false;
    }
}
