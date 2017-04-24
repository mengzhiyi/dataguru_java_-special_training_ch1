package agiledon.codekata.refactoring.moviestore;

class Customer {
    private String name;
    private RentalSet rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new RentalSet();
    }
    
    public String getName() {
        return name;
    }

    public void addRental(Rental arg){
    	rentals.addRental(arg);
    }
    
    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        result += rentals.showRentals();
        
        return result;
    }
}
