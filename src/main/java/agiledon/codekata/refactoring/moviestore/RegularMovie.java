package agiledon.codekata.refactoring.moviestore;

public class RegularMovie extends Movie{
	
    public RegularMovie(String title) {
    	super(title);
    }

    public boolean isNewRelease(){
    	return false;
    }
}
