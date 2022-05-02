package co.edu.uniquindio.ssev.vehicletracking.customer.domain.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4190154946101044841L;
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
	
	
}
