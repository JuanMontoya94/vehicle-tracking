package co.edu.uniquindio.ssev.vehicletracking.customer.domain.exception;

public class CustomerCantBeDeletedException extends RuntimeException {

	private static final long serialVersionUID = -4803858189714364555L;

	public CustomerCantBeDeletedException(String message) {
		super(message);
	}
}
