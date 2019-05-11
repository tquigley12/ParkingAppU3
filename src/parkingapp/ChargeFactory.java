package parkingapp;

/**
 * This is the interface for the charge factory routine.
 * 
 * @author tquigley1
 */
public interface ChargeFactory {

    ChargeStrategy make(String chargeStrategy, int checkInTime, int checkOutTime);
}
