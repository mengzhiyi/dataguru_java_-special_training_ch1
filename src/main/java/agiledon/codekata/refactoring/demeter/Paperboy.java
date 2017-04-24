package agiledon.codekata.refactoring.demeter;


public class Paperboy {
    
	private Customer myCustomer;
    public void setMyCustomer(Customer myCustomer) {
		this.myCustomer = myCustomer;
	}

	public void pay(float payment) {
    	myCustomer.doPay(payment);
    }
}
