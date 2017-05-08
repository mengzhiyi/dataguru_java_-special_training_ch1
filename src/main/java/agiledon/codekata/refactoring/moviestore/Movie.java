package agiledon.codekata.refactoring.moviestore;

public abstract class Movie {
	
    private String title;

    public Movie(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
      
    public abstract boolean isNewRelease();
}
