package agiledon.codekata.refactoring.moviestore;

public class ChildrenMovie extends Movie{
	
    public ChildrenMovie(String title) {
    	super(title);
    }

    public boolean isNewRelease(){
    	return false;
    }
}
