package agiledon.codekata.refactoring.moviestore;

public class Movie {
	
    private String title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }
    public void setPriceCode(PriceCode arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }
       
}
