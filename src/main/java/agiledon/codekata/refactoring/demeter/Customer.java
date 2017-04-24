package agiledon.codekata.refactoring.demeter;

public class Customer {
	
	public static class Name {
		private String firstName;
	    private String lastName;
	    
	    public Name(String firstName, String lastName){
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    }
	    
	    public String getFirstName(){
	        return firstName;
	    }
	    public String getLastName(){
	        return lastName;
	    }
	}
	    
    private Name name;
    private Wallet myWallet;
    
    public Customer(Name name, Wallet wallet){
    	this.name = name;
    	this.myWallet = wallet;
    }
    
    public boolean doPay(float payment){
    	if (myWallet.isEnoughMoneyToPay(payment)) {
    		myWallet.subtractMoney(payment);
    		return true;
    	}
		
    	return false;
    }
}