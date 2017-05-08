package agiledon.codekata.refactoring.moviestore;

public class NewReleaseMovie extends Movie{
	
    public NewReleaseMovie(String title) {
    	super(title);
    }

    public boolean isNewRelease(){
    	return true;
    }
}
