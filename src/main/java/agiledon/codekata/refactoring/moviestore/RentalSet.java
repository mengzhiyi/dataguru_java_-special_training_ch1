package agiledon.codekata.refactoring.moviestore;

import java.util.ArrayList;
import java.util.List;

public class RentalSet {
	
	private List<Rental> rentals = new ArrayList<Rental>();

	public void addRental(Rental arg) {
        rentals.add(arg);
    }
	
	public String showRentals(){
		double totalAmount = 0;
        int frequentRenterPoints = 0;
		String result = "";
		
        for (Rental each : rentals) {
            double thisAmount = each.determineAmounts();

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if (each.isMovieNewRelease())
                frequentRenterPoints++;
            
            //show figures
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
		
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        
        return result;
	}
	
	
}
